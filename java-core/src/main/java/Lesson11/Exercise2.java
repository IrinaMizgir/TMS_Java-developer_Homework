package Lesson11;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 02.04.2026 15:59
 */

//Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
//значений их длины.

public class Exercise2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();
        System.out.print("Введите третью строку: ");
        String str3 = scanner.nextLine();

        // Сортировка трёх строк по длине (пузырьковая или просто сравнения)
        String temp;
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if (str2.length() > str3.length()) {
            temp = str2;
            str2 = str3;
            str3 = temp;
        }
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }

        System.out.println("\nСтроки в порядке возрастания длины:");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);


    }
}
