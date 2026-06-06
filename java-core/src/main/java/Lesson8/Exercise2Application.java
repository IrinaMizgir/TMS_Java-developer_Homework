package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 14:33
 */
//Создать класс Apple и добавить в него поле color с модификатором доступа private и
//инициализировать его. В методе main другого класса создать объект Apple, и не
//используя сеттеры изменить значение поля color.


public class Exercise2Application {

    public static class Apple {
        private String color = "Green";
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.color = "Red"; //Java не ругается т.к. это поле вложенного класса.
        System.out.println(apple.color);
    }
}

