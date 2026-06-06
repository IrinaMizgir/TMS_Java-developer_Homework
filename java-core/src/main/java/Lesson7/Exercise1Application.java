package Lesson7;

/**
 * @author Ирина Мизгир
 * @date 21.03.2026 23:47
 */

//Задача 1:
//Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
//который печатает название должности и имплементировать этот метод в созданные классы.

public class Exercise1Application {

    public static void main(String[] args) {
        Employee director = new Director();
        Employee worker = new Worker();
        Employee accountant = new Accountant();
        director.printPosition();
        worker.printPosition();
        accountant.printPosition();
    }

    public interface Employee {

        /**
         * Печатает название должности.
         */
        void printPosition();

    }

    public static class Director implements Employee {

        @Override
        public void printPosition() {
            System.out.println("Директор");
        }
    }

    public static class Worker implements Employee {

        @Override
        public void printPosition() {
            System.out.println("Рабочий");
        }

    }

    public static class Accountant implements Employee {

        @Override
        public void printPosition() {
            System.out.println("Бухгалтер");
        }

    }
}
