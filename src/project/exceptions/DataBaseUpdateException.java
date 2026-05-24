package project.exceptions;

import java.sql.SQLException;

/**
 * Исключение при обновлении данных в базе данных.
 * @author Ирина Мизгир
 * @date 02.05.2026 18:46
 */
public class DataBaseUpdateException extends RuntimeException {

    public DataBaseUpdateException(String message, SQLException cause) {
        super(message, cause);
    }
}
