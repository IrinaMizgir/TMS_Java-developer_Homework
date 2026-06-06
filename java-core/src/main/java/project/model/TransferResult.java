package project.model;

import java.util.List;

/**
 * Результат перевода.
 *
 * @param transfer Перевод.
 * @param transferResultStatusInfos Информация о статусах перевода.
 * @author Ирина Мизгир
 * @date 27.04.2026 14:37
 */
public record TransferResult(Transfer transfer, List<TransferResultStatusInfo> transferResultStatusInfos) {

    /**
     * Информация о статусе перевода.
     *
     * @param status Статус перевода.
     * @param statusMessage Сообщение о статусе перевода.
     */
    public record TransferResultStatusInfo(TransferStatus status, String statusMessage) {

        /**
         * Статус перевода.
         */
        public enum TransferStatus {

            /**
             * Невалидный перевод.
             */
            INVALID_TRANSFER,

            /**
             * Невалидный номер отправителя.
             */
            INVALID_FROM_NUMBER,

            /**
             * Невалидный номер получателя.
             */
            INVALID_TO_NUMBER,

            /**
             * Невалидная сумма.
             */
            INVALID_SUM,

            /**
             * Не найден номер отправителя.
             */
            NOT_FOUND_FROM_NUMBER,

            /**
             * Не найден номер получателя.
             */
            NOT_FOUND_TO_NUMBER,

            /**
             * Недостаточно средств.
             */
            INSUFFICIENT_FUNDS,

            /**
             * Успешно обработан перевод.
             */
            SUCCESS

        }

    }

}
