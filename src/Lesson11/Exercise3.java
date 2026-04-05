package Lesson11;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 02.04.2026 15:59
 */

//Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//средней, а также их длину.

public class Exercise3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();
        System.out.print("Введите третью строку: ");
        String str3 = scanner.nextLine();

        // Получение длины строк с помощью метода length() класса String.
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        // Вычисление средней длины
        double average = (len1 + len2 + len3) / 3d;

        // Проверка и вывод строк, длина которых меньше средней.
        if (len1 < average) {
            System.out.println("\"" + str1 + "\" — длина: " + len1);
        }
        if (len2 < average) {
            System.out.println("\"" + str2 + "\" — длина: " + len2);
        }
        if (len3 < average) {
            System.out.println("\"" + str3 + "\" — длина: " + len3);
        }

    }
}
