package Lesson2; /**
 * @author Ирина Мизгир
 * @date 03.03.2026 18:55
 */

//Напишите программу, которая будет принимать на вход число из консоли и на выход
//будет выводить сообщение четное число или нет. Для определения четности числа
//используйте операцию получения остатка от деления (операция выглядит так: '% 2').

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.print("запускаюсь");
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        System.out.print("Введите число: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                System.out.println("Число " + number + " - четное");
            } else {
                System.out.println("Число " + number + " - нечетное");
            }
        } else {
            System.out.println("Ошибка: Введено не целое число");
        }

        scanner.close();
    }
}
