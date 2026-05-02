package project.service;

import project.exceptions.DataBaseUpdateException;
import project.model.DatePeriod;
import project.model.Transfer;
import project.model.TransferResult;
import project.util.ConsoleUtils;
import project.util.FileUtils;
import project.util.JDBCUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Обработчик для отчетов.
 *
 * @author Ирина Мизгир
 * @date 27.04.2026 15:18
 */
public class ReportService {

    /**
     * Имя файла отчёта.
     */
    private static final String REPORT_FILENAME = "report.txt";

    /**
     * Префикс временного файла отчёта.
     */
    private static final String TEMP_REPORT_FILE_PREFIX = "report_";

    /**
     * Путь к рабочей папке.
     */
    private final Path workingDirPath;


    public ReportService(Path workingDirPath) {
        this.workingDirPath = workingDirPath;
    }

    /**
     * Печатает отчёт.
     */
    public void printReport() {
        printReportFilePath();
    }

    /**
     * Печатает отчёт за период.
     */
    public void printReportByPeriod() {
        LocalDate start = ConsoleUtils.getLocalDate("Введите дату начала отчета: ");
        LocalDate finish = ConsoleUtils.getLocalDate("Введите дату окончания отчета: ");
        if (start.isAfter(finish)) {
            System.out.println("Неверный период.");
            return;
        }
        var period = new DatePeriod(start, finish);
        List<String> lines = getReportLines();
        if (lines.isEmpty()) {
            System.out.println("Не найден файл отчет.");
            return;
        }
        List<String> linesByPeriod = lines.stream()
                .filter(line -> filterLineByPeriod(line, period))
                .toList();

        if (linesByPeriod.isEmpty()) {
            System.out.printf("Нет данных для отчета за период с %s по %s %n", start, finish);
            return;
        }
        Path tempReportFilePath = FileUtils.writeLinesToTempTextFile(TEMP_REPORT_FILE_PREFIX, linesByPeriod);
        ConsoleUtils.printPath("Данные отчета с %s по %s ".formatted(start, finish), tempReportFilePath);
    }

    /**
     * Фильтрация линии отчёта по периоду.
     *
     * @param line Линия отчёта.
     * @param period Период отчёта.
     * @return true - линия входит в период.
     */
    private boolean filterLineByPeriod(String line, DatePeriod period) {
        return period.isInPeriodInclusive(LocalDateTime.parse(line.substring(0, line.indexOf("|"))).toLocalDate());
    }

    /**
     * Добавляет данные в отчёт.
     *
     * @param transferResults Список результатов.
     */
    public void addResults(List<TransferResult> transferResults) {
        List<String> serializedReportResults = transferResults.stream()
                .map(this::serializeReportResultToString)
                .toList();

        Path reportUserDataPath = workingDirPath.resolve(REPORT_FILENAME);
        FileUtils.appendAllLinesToPath(reportUserDataPath, serializedReportResults);
        System.out.println("Файл отчёта успешно сохранён");

        int [] dataBaseResult = JDBCUtils.executeBatchUpdate("INSERT INTO report (time, file_name, transfer, status) VALUES (?,?,?,?)",
                preparedStatement -> transferResults.forEach(transferResult -> {
                    try {
                        Transfer transfer = transferResult.transfer();
                        preparedStatement.setTimestamp(1, Timestamp.valueOf(transfer.getDate()));
                        preparedStatement.setString(2, transfer.getFileName());
                        preparedStatement.setString(3, getAccountTransferMessage(transfer));
                        preparedStatement.setString(4, getTransferStatusMessage(transferResult.transferResultStatusInfos()));
                        preparedStatement.addBatch();
                    } catch (SQLException exception) {
                        throw new DataBaseUpdateException("Ошибка при добавлении данных о файле отчёте ",exception);
                    }
                }));
        System.out.println("Данные отчёта успешно сохранены в базу данных: " + Arrays.toString(dataBaseResult));


        ConsoleUtils.printPath("Данные отчёта: ", reportUserDataPath);
    }

    /**
     * Сериализация результата перевода в строку.
     *
     * @param result Результат перевода.
     * @return Строка.
     */
    private String serializeReportResultToString(TransferResult result) {
        Transfer transfer = result.transfer();

        return transfer.getDate().truncatedTo(ChronoUnit.SECONDS)
                + "|" + transfer.getFileName()
                + "|" + getAccountTransferMessage(transfer)
                + "|" + getTransferStatusMessage(result.transferResultStatusInfos());

    }

    /**
     * Возвращение сообщения статуса перевода.
     *
     * @param statusInfoList Список статусов перевода.
     * @return Строка статуса.
     */
    private String getTransferStatusMessage(List<TransferResult.TransferResultStatusInfo> statusInfoList) {
        if (statusInfoList.size() == 1 && TransferResult.TransferResultStatusInfo.TransferStatus.SUCCESS.equals(statusInfoList.get(0).status())) {
            return statusInfoList.get(0).statusMessage();
        }

        return statusInfoList.stream()
                .map(TransferResult.TransferResultStatusInfo::statusMessage)
                .collect(Collectors.joining(", ", "Ошибка во время обработки: ", ""));
    }

    /**
     * Возвращает сообщение о переводе на счет.
     *
     * @param transfer Перевод.
     * @return Строка с сообщением о переводе на счет.
     */

    private String getAccountTransferMessage(Transfer transfer) {
        return transfer.getFromAccountNumber().isEmpty()
                && transfer.getToAccountNumber().isEmpty()
                && Double.isNaN(transfer.getSum())
                ? "Некорректный перевод"
                : "Перевод с %s на %s %.2f".formatted(transfer.getFromAccountNumber(), transfer.getToAccountNumber(), transfer.getSum());
    }

    /**
     * Напечатает путь к файлу отчёту в консоль.
     *
     */
    private void printReportFilePath() {
        Path reportUserDataPath = workingDirPath.resolve(REPORT_FILENAME);
        if (Files.exists(reportUserDataPath)) {
            ConsoleUtils.printPath("Данные отчёта: ", reportUserDataPath);
        } else {
            System.out.println("Не найден файл отчёт.");
        }
    }

    /**
     * Получит линии текущего отчёта.
     *
     * @return Список линий отчёта.
     */
    private List<String> getReportLines() {
        Path reportUserDataPath = workingDirPath.resolve(REPORT_FILENAME);

        return Files.exists(reportUserDataPath)
                ? FileUtils.readAllLinesFromPath(reportUserDataPath)
                : Collections.emptyList();
    }
}
