package project.util;

import project.exceptions.DataBaseAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * Utility-клвсс для работы с базой данных.
 *
 * @author Ирина Мизгир
 * @date 02.05.2026 17:09
 */
public final class JDBCUtils {
    /**
     * Строка подключения.
     */
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres_db";
    /**
     * Пользователь.
     */
    private static final String USER = "postgres_user";
    /**
     * Пароль.
     */
    private static final String PASSWORD = "postgres_password";

    private JDBCUtils() {

    }

    /**
     * Выполнит пачку запросов.
     *
     * @param statementConsumer Потребитель запросов.
     * @param query Запрос.
     */
    public static void executeBatchUpdate(String query, Consumer<PreparedStatement> statementConsumer) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            //noinspection SqlSourceToSinkFlow
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                statementConsumer.accept(preparedStatement);
                preparedStatement.executeBatch();
            }
        } catch (SQLException exception) {
            throw new DataBaseAccessException("Ошибка доступа к базе данных", exception);
        }
    }
}
