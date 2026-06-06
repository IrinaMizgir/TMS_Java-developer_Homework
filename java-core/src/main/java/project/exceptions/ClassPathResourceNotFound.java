package project.exceptions;

/**
 * Исключение если не найден ресурс в пути к классам.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 14:04
 */
public class ClassPathResourceNotFound extends RuntimeException {

    public ClassPathResourceNotFound(Exception cause) {
        super("Не найден ресурс в пути к классам", cause);
    }
}
