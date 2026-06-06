package Lesson13;

/**
 * @author Ирина Мизгир
 * @date 11.04.2026 17:26
 */
public final class AuthorizationValidator {

    private AuthorizationValidator() {

    }

    /**
     * Проверка данных регистрации.
     *
     * @param login логин.
     * @param password пароль.
     * @param confirmPassword подтверждение пароля.
     * @return результат проверки.
     * @throws WrongLoginException в случае неверного логина
     * @throws WrongPasswordException в случае неверного пароля и(или) подтверждения пароля.
     */
    public static boolean validate(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Не верный логин содержит больше 20 символов.");
        }
        if (login.contains(" ")) {
            throw new WrongLoginException("Не верный логин содержит пробел.");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Не корректный пароль содержит больше 20 символов.");
        }
        if (password.contains(" ")) {
            throw new WrongPasswordException("Не корректный пароль содержит пробел.");
        }
        if (!password.matches(".*\\d+.*")) {
            throw new WrongPasswordException("Не корректный пароль (должен содержать одну цифру или несколько цифр).");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
        }

        return true;

    }

    /**
     * Исключение при неверном логине.
     */
    public static class WrongLoginException extends RuntimeException {

        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    /**
     * Исключение при неверном пароле и(или) подтверждении пароля.
     */
    public static class WrongPasswordException extends RuntimeException {

        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
