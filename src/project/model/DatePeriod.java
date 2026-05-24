package project.model;

import java.time.LocalDate;

/**
 * Период.
 *
 * @param startDate Начала периода.
 * @param endDate Конец периода.
 * @author Ирина Мизгир
 * @date 27.04.2026 15:57
 */
public record DatePeriod(LocalDate startDate, LocalDate endDate) {
    /**
     * Проверит вхождение даты в период (включая дату начала и окончания).
     *
     * @param date Дата для проверки.
     * @return Результат проверки.
     */
    public boolean isInPeriodInclusive(LocalDate date) {
        return date.isEqual(startDate) || date.isEqual(endDate) || isInsidePeriod(date);
    }

    /**
     * Проверит вхождение даты в период.
     *
     * @param date Дата для проверки.
     * @return Результат проверки.
     */
    private boolean isInsidePeriod(LocalDate date) {
        return startDate.isBefore(date) && endDate.isAfter(date);
    }
}
