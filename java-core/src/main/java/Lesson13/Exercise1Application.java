package Lesson13;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 11.04.2026 14:43
 */
//Создать класс, в котором будет статический метод. Этот метод принимает на вход три
//параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
//login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
//соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
//password должна быть меньше 20 символов, не должен содержать пробелом и должен
//содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
//Если password не соответствует этим требованиям, необходимо выбросить
//WrongPasswordException. WrongPasswordException и WrongLoginException -
//пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//второй принимает сообщение исключения и передает его в конструктор класса Exception.
//Метод возвращает true, если значения верны, false в противном случае.

public class Exercise1Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = input.nextLine();
        System.out.println("Введите пароль: ");
        String password = input.nextLine();
        System.out.println("Подтвердите пароль: ");
        String confirmPassword = input.nextLine();
        try {
            boolean result = AuthorizationValidator.validate(login, password, confirmPassword);
            if (result) {
                System.out.println("Вход успешен!");
            }
        } catch (AuthorizationValidator.WrongLoginException wrongLoginException) {
            System.out.println("Пользователь пытается зайти с неверным логином: " + login);
            throw wrongLoginException;
        } catch (AuthorizationValidator.WrongPasswordException wrongPasswordException) {
            System.out.println("Пользователь пытается зайти с неверным паролем или подтверждением пароля: " + password);
            throw wrongPasswordException;
        }

    }
}
