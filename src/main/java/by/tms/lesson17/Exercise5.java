package by.tms.lesson17;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * @author Ирина Мизгир
 * @date 29.04.2026 16:00
 */

//Задача 5:
//Используя Supplier написать метод, который будет возвращать введенную с консоли
//строку задом наперед.

public class Exercise5 {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите строку: ");

            return new StringBuilder(input.nextLine()).reverse().toString();
        };

        System.out.println(supplier.get());
    }
}
