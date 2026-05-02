package project.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Класс для перевода.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 18:08
 */
public class Transfer {
    /**
     * Дата перевода.
     */
    private final LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    /**
     * Номер счета с.
     */
    private final String fromAccountNumber;
    /**
     * Номер счета на.
     */
    private final String toAccountNumber;
    /**
     * Сумма перевода.
     */
    private final double sum;
    /**
     * Имя файла откуда был получен перевод.
     */
    private final String fileName;

    public Transfer(String fromAccountNumber, String toAccountNumber, double sum, String fileName) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.sum = sum;
        this.fileName = fileName;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getSum() {
        return sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * Создаст невалидный перевод.
     * @param fileName Имя файла.
     * @return Перевод.
     */
    public static Transfer createInvalidTransfer(String fileName) {
        return new Transfer("", "", Double.NaN, fileName);
    }


}
