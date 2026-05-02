package project.application;

import project.service.ReportService;
import project.service.TransferService;
import project.model.TransferResult;
import project.util.ConsoleUtils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Класс реализующий логику приложения.
 *
 * @author Ирина Мизгир
 * @date 27.04.2026 14:41
 */
public class TransferApplication implements Runnable {

    /**
     * Сервис для переводов.
     */
    private final TransferService transferService;

    /**
     * Сервис для отчётов.
     */
    private final ReportService reportService;

    public TransferApplication() {
        Path path = ConsoleUtils.getFolderAsAbsolutePath("Введите рабочую папку: ");
        this.transferService = new TransferService(path);
        this.reportService = new ReportService(path);
    }

    /**
     * Запустит выполнение программы.
     */
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            RunType type = ConsoleUtils.getFromString("Выберите операцию: 1 - парсинг, 2 - отчёт, " +
                    "3 - отчёт за период, q - выход.", RunType::fromCode);
            switch (type) {
                case TRANSFER -> transfer();
                case REPORT -> reportService.printReport();
                case REPORT_BY_PERIOD -> reportService.printReportByPeriod();
                case QUIT -> flag = false;
            }
        }
    }

    /**
     * Выполнит переводы.
     */
    private void transfer() {
        List<TransferResult> transferResults = transferService.transfer();
        if (!transferResults.isEmpty()) {
            reportService.addResults(transferResults);
        }
    }

    /**
     * Тип запуска.
     */
    private enum RunType {

        /**
         * Обработка переводов.
         */
        TRANSFER("1"),
        /**
         * Отображение отчета.
         */
        REPORT("2"),
        /**
         * Отчет за дату.
         */
        REPORT_BY_PERIOD("3"),
        /**
         * Покинуть приложение.
         */
        QUIT("q");

        /**
         * Код типа.
         */
        private final String code;

        RunType(String code) {
            this.code = code;
        }

        /**
         * Получит тип запуска из кода.
         *
         * @param code Код.
         * @return Тип запуска.
         */
        private static RunType fromCode(String code) {
            return Arrays.stream(values())
                    .filter(runType -> runType.code.equals(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Неверный код: " + code));
        }

    }
}
