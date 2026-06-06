package project.exceptions;

/**
 * Исключение если не найдены данные счетов.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 13:55
 */
public class AccountsNotFoundException extends RuntimeException {

    public AccountsNotFoundException() {
        super("Не найдены счета");
    }
}
