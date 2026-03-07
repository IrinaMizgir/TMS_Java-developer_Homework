package Lesson2; /**
 * @author Ирина Мизгир
 * @date 03.03.2026 19:39
 */
//Напишите программу, где пользователь вводит любое целое положительное число. А
//программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
//числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
//ввести некорректные данные.

import java.util.Scanner;


public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        // Ввод числа с проверкой корректности
        while (!validInput) {
            System.out.print("Введите целое положительное число: ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number > 0) {
                    validInput = true;
                } else {
                    System.out.println("Ошибка: число должно быть положительным. Попробуйте снова.");
                }
            } else {
                System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
                scanner.next(); // Очистка некорректного ввода
            }
        }

        // Вычисление суммы чисел от 1 до введенного числа
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        // Вывод результата
        System.out.println("Сумма чисел от 1 до " + number + " = " + sum);

        scanner.close();
    }
}
