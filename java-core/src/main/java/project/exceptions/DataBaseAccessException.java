package project.exceptions;

import java.sql.SQLException;

/**
 * Ошибка доступа к базе данных.
 *
 * @author Ирина Мизгир
 * @date 02.05.2026 19:25
 */
public class DataBaseAccessException extends RuntimeException {

    public DataBaseAccessException(String message, SQLException cause) {
        super(message, cause);
    }
}
