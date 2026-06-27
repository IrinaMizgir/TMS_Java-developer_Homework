package by.tms.lesson33.model;

import lombok.Data;

/**
 * Пользователь.
 *
 * @author Ирина Мизгир
 * @date 27.06.2026 18:39
 */
@Data
public class User {

    /**
     * Идентификатор.
     */
    private Integer id;
    /**
     * Имя пользователя.
     */
    private String userName;
    /**
     * Логин (E-mail).
     */
    private String email;
}
