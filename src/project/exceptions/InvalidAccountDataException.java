package project.exceptions;

/**
 * Исключение если не валидны данные счетов.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 15:14
 */
public class InvalidAccountDataException extends RuntimeException {

    public InvalidAccountDataException(String message) {
        super(message);
    }
}
