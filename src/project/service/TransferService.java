package project.service;

import project.exceptions.AccountsNotFoundException;
import project.exceptions.DataBaseUpdateException;
import project.exceptions.InvalidAccountDataException;
import project.model.Account;
import project.model.TextFileInfo;
import project.model.Transfer;
import project.model.TransferResult;
import project.model.TransferResult.TransferResultStatusInfo;
import project.model.TransferResult.TransferResultStatusInfo.TransferStatus;
import project.util.ConsoleUtils;
import project.util.FileUtils;
import project.util.JDBCUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Обработчик переводов.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 13:26
 */
public class TransferService {

    /**
     * Имя файла для хранения счётов.
     */
    private static final String ACCOUNTS_FILENAME = "accounts.txt";
    /**
     * Папка с файлами для переводов.
     */
    private static final String INPUT_DIRECTORY = "input";

    /**
     * Папка с архивными переводами.
     */
    private static final String ARCHIVE_DIRECTORY = "archive";

    /**
     * Путь к рабочей папке.
     */
    private final Path workingDirPath;
    /**
     * Map из номера счёта и счёта.
     */
    private final Map<String, Account> accounts;


    public TransferService(Path workingDirPath) {
        this.workingDirPath = workingDirPath;
        accounts = loadAccounts();
    }

    /**
     * Загрузка данных счетов.
     *
     * @return Map из номера счёта и счёта.
     */
    private Map<String, Account> loadAccounts() {
        Path accountsUserDataPath = workingDirPath.resolve(ACCOUNTS_FILENAME);
        if (Files.exists(accountsUserDataPath) && Files.isRegularFile(accountsUserDataPath)) {
            return parseAccountsFromLines(FileUtils.readAllLinesFromPath(accountsUserDataPath));
        }

        List<String> lines = FileUtils.loadClassPathResourceAsLinesList(ACCOUNTS_FILENAME);
        FileUtils.writeAllLinesToPath(accountsUserDataPath, lines);
        System.out.println("Первоначальные данные успешно сохранены в рабочий файл");
        Map<String, Account> dataMap = parseAccountsFromLines(lines);
        JDBCUtils.executeBatchUpdate("INSERT INTO accounts (number, sum) VALUES (?,?)", preparedStatement ->
                dataMap.values().forEach(account -> {
                    try {
                        preparedStatement.setString(1, account.getNumber());
                        preparedStatement.setDouble(2, account.getBalance());
                        preparedStatement.addBatch();
                    } catch (SQLException exception) {
                        throw new DataBaseUpdateException("Ошибка при добавлении первоначальных данных о счетах ", exception);
                    }
                }));
        System.out.println("Первоначальные данные успешно сохранены в базу данных");

        return dataMap;
    }

    /**
     * Разбор данных счетов из линий файла.
     *
     * @param lines Линии файла.
     * @return Map из номера счёта и счёта.
     */
    private Map<String, Account> parseAccountsFromLines(List<String> lines) {
        if (lines.isEmpty()) {
            throw new AccountsNotFoundException();
        }
        return lines.stream()
                .filter(line -> !line.isBlank())
                .map(this::parse)
                .collect(Collectors.toMap(Account::getNumber, Function.identity(), ((account, account2) -> {
                    throw new InvalidAccountDataException("Дублированные счета: " + account.getNumber());
                })));
    }

    /**
     * Разбор линий файла счёта.
     *
     * @param line Линия файла.
     * @return Счёт.
     */
    private Account parse(String line) {
        String[] split = line.split("\\|");
        if (split.length != 2) {
            throw new InvalidAccountDataException("Невалидные данные аккаунта: " + line);
        }
        String numberAccount = split[0];
        if (isInvalidAccountNumber(numberAccount)) {
            throw new InvalidAccountDataException("Невалидный номер счета: " + numberAccount);
        }
        String balanceAsString = split[1];
        try {
            double balance = Double.parseDouble(balanceAsString);
            if (balance < 0) {
                throw new InvalidAccountDataException("Баланс на счете не может быть меньше нуля: " + balance);
            }
            return new Account(numberAccount, balance);
        } catch (NumberFormatException exception) {
            throw new InvalidAccountDataException("Невалидная сумма на счете: " + balanceAsString);
        }
    }

    /**
     * Проверка, что номер счёта невалидный.
     *
     * @param accountNumber Номер счёта.
     * @return Результат проверки.
     */
    private boolean isInvalidAccountNumber(String accountNumber) {
        return !accountNumber.matches("^[0-9]{5}-[0-9]{5}$");
    }

    /**
     * Сериализует объект счёта в строку.
     *
     * @param account Счёт.
     * @return Строка с информацией о счёте.
     */
    private String serializeAccountToString(Account account) {
        return account.getNumber() + "|" + BigDecimal.valueOf(account.getBalance())
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();
    }

    /**
     * Выполнение переводов.
     */
    public List<TransferResult> transfer() {
        Path inputPath = workingDirPath.resolve(INPUT_DIRECTORY);
        if (Files.notExists(inputPath)) {
            System.out.println("Нет папки с переводами");
            return Collections.emptyList();
        }
        if (!Files.isDirectory(inputPath)) {
            System.out.println("Input не является папкой");
            return Collections.emptyList();
        }
        List<TransferResult> results = FileUtils.loadTextFiles(inputPath).stream()
                .flatMap(this::processTransfers)
                .toList();

        if (results.isEmpty()) {
            System.out.println("Нет данных для парсинга.");
            return Collections.emptyList();
        }

        List<String> serializedAccounts = accounts.values().stream()
                .map(this::serializeAccountToString)
                .toList();
        Path accountsUserDataPath = workingDirPath.resolve(ACCOUNTS_FILENAME);
        FileUtils.writeAllLinesToPath(accountsUserDataPath, serializedAccounts);
        System.out.println("Данные счетов успешно сохранены в рабочий файл");
        JDBCUtils.executeBatchUpdate("UPDATE accounts SET sum = ? WHERE number = ?", preparedStatement ->
                accounts.values().forEach(account -> {
                    try {
                        preparedStatement.setDouble(1, account.getBalance());
                        preparedStatement.setString(2, account.getNumber());
                        preparedStatement.addBatch();
                    } catch (SQLException exception) {
                        throw new DataBaseUpdateException("Ошибка при обновлении данных о счетах ", exception);
                    }
                }));
        System.out.println("Данные счетов успешно обновлены в базе данных");
        ConsoleUtils.printPath("Актуальные данные счетов: ", accountsUserDataPath);

        return results;
    }

    /**
     * Обработка переводов.
     *
     * @param textFileInfo Информация о текстовом файле.
     * @return Stream из результатов переводов.
     */
    private Stream<TransferResult> processTransfers(TextFileInfo textFileInfo) {
        List<TransferResult> results = textFileInfo.lines().stream()
                .map(line -> processTransferLine(line, textFileInfo))
                .toList();

        FileUtils.moveFileToDirectoryWithUniqueName(textFileInfo.path(), workingDirPath.resolve(ARCHIVE_DIRECTORY));

        return results.stream();
    }

    /**
     * Обработка линий перевода.
     *
     * @param line Строка (линия) перевода.
     * @param textFileInfo Информация о текстовом файле.
     * @return Результат перевода.
     */
    private TransferResult processTransferLine(String line, TextFileInfo textFileInfo) {
        String fileName = textFileInfo.path().getFileName().toString();
        List<TransferResultStatusInfo> transferResultStatusInfos = new ArrayList<>();
        String[] split = line.split("\\|");
        if (split.length < 3) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INVALID_TRANSFER, "невалидные данные перевода: " + line));
            return new TransferResult(Transfer.createInvalidTransfer(fileName), transferResultStatusInfos);
        }
        String fromNumberAccount = split[0];

        String toNumberAccount = split[1];

        String sumAsString = split[2];
        double sum = parseTransferSumOrNan(sumAsString);
        Transfer transfer = new Transfer(fromNumberAccount, toNumberAccount, sum, fileName);
        if (isInvalidAccountNumber(fromNumberAccount)) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INVALID_FROM_NUMBER,
                    "невалидный номер аккаунта источника перевода: " + fromNumberAccount));

        }
        if (isInvalidAccountNumber(toNumberAccount)) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INVALID_TO_NUMBER,
                    "невалидный номер аккаунта получателя перевода: " + toNumberAccount));
        }
        if (Double.isNaN(sum) || sum <= 0) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INVALID_SUM,
                    "невалидная сумма перевода: " + sumAsString));
        }
        if (!transferResultStatusInfos.isEmpty()) {
            return new TransferResult(transfer, transferResultStatusInfos);
        }
        if (!accounts.containsKey(fromNumberAccount)) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INVALID_FROM_NUMBER,
                    "не найден счет источника перевода: " + fromNumberAccount));
            return new TransferResult(transfer, transferResultStatusInfos);
        }
        if (!accounts.containsKey(toNumberAccount)) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.NOT_FOUND_TO_NUMBER,
                    "не найден счет получателя: " + toNumberAccount));
            return new TransferResult(transfer, transferResultStatusInfos);
        }
        Account fromAccount = accounts.get(fromNumberAccount);
        if (!fromAccount.checkBalance(sum)) {
            transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.INSUFFICIENT_FUNDS,
                    "недостаточно средств для перевода: " + sum));
            return new TransferResult(transfer, transferResultStatusInfos);
        }
        fromAccount.subtractSum(sum);
        accounts.get(toNumberAccount).addSum(sum);
        transferResultStatusInfos.add(new TransferResultStatusInfo(TransferStatus.SUCCESS, "Успешно обработан"));

        return new TransferResult(transfer, transferResultStatusInfos);

    }

    /**
     * Разберёт сумму перевода или вернёт объект НЕ числа.
     *
     * @param sumAsString Сумма как строка.
     * @return Сумма перевода.
     */
    private double parseTransferSumOrNan(String sumAsString) {
        try {
            return Double.parseDouble(sumAsString);
        } catch (NumberFormatException exception) {
            return Double.NaN;
        }
    }

}
