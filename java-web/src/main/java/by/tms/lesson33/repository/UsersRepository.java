package by.tms.lesson33.repository;

import by.tms.lesson33.model.User;

import java.sql.*;
import java.util.OptionalInt;

/**
 * Репозиторий для работы с пользователями.
 *
 * @author Ирина Мизгир
 * @date 27.06.2026 19:40
 */
public class UsersRepository {

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

    /**
     * Экземпляр класса (одиночка).
     */
    private static final UsersRepository INSTANCE = new UsersRepository();

    private UsersRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
    }

    /**
     * Получения пользователя по id.
     *
     * @param id Идентификатор.
     * @return Пользователь.
     */
    public User getById(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User();
            user.setId(resultSet.getInt("ID"));
            user.setUserName(resultSet.getString("USER_NAME"));
            user.setEmail(resultSet.getString("EMAIL"));
            return user;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Сохранение пользователя.
     *
     * @param user Пользователь.
     */
    public void save(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (USER_NAME, EMAIL) VALUES (?, ?)")
        ) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Удаления пользователя по id.
     *
     * @param id Идентификатор.
     * @return Результат удаления.
     */
    public boolean deleteById(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            int deletedCount = preparedStatement.executeUpdate();
            return deletedCount == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Поиск id по логину (E-mail).
     *
     * @param email Логин (E-mail).
     * @return Опциональный id.
     */
    public OptionalInt findUserIdByEmail(String email) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM users WHERE email = ?")
        ) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return OptionalInt.of(resultSet.getInt("id"));
            }
            return OptionalInt.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Обновление логина (E-mail).
     *
     * @param user Пользователь.
     */
    public void updateLogin(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET email = ? WHERE id = ?;")
        ) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение экземпляра одиночки.
     *
     * @return экземпляр репозитория.
     */
    public static UsersRepository getInstance() {
        return INSTANCE;
    }
}
