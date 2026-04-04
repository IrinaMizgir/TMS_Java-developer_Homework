package Lesson10;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 04.04.2026 15:06
 */
//Создать программу для реализации поверхностного и глубокого клонирования объекта
//класса User. Пусть на вход программе будет передаваться тип операции клонирования
//(поверхностное клонирование или глубокое), а также id юзера для клонирования.

public class Exercise2Application {

    public static void main(String[] args) throws CloneNotSupportedException {
        User[] users = {
                new User(1, "Забава", 26, "zabava2000@gmail.com", new Address("Козлова", "25", 903)),
                new User(2, "Алёша", 36, "alesha5245@gmail.com", new Address("Жукова", "42", 42)),
                new User(3, "Иван", 30, "ivan1996@gmail.com", new Address("Независимости", "95А", 12))
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Введите id пользователя: ");
        int id = input.nextInt();

        User foundedUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                foundedUser = user;
                break;
            }
        }
        if (foundedUser == null) {
            System.out.println("Пользователь не найден по id: " + id);
        } else {
            System.out.println(foundedUser);
            System.out.println("Выберите тип операции клонирования\n" +
                    "//(поверхностное клонирование =1 или глубокое = 2)");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println(foundedUser.clone());
            } else if (choice == 2) {
                System.out.println(foundedUser.deepClone());
            } else {
                System.out.println("Неизвестный тип клонирования");
            }
        }

    }
}
