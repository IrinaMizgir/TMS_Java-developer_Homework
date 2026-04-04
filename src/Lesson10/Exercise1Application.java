package Lesson10;

/**
 * @author Ирина Мизгир
 * @date 04.04.2026 14:12
 */

//Создать класс для описания пользователя системы. Переопределить в классе методы
//toString, hashcode и equals. Создать несколько экземпляров класса с одним и тем же
//значением полей и сравнить с помощью метода equals.

public class Exercise1Application {

    public static void main(String[] args) {
        User user1 = new User(1, "Забава", 26, "zabava2000@gmail.com", new Address("Козлова", "25", 903));
        User user2 = new User(1, "Забава", 26, "zabava2000@gmail.com", new Address("Козлова", "25", 903));
        User user3 = new User(3, "Иван", 30, "ivan1996@gmail.com", new Address("Независимости", "95А", 12));
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));
        System.out.println(user2.equals(user3));
        System.out.println(user2);
        System.out.println(user1.hashCode());
        System.out.println(user3.hashCode());
    }
}
