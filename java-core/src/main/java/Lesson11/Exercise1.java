package Lesson11;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 02.04.2026 15:59
 */
//Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//найденные строки и их длину.

public class Exercise1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ввод трёх строк
        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();
        System.out.print("Введите третью строку: ");
        String str3 = scanner.nextLine();

        // Инициализация самой короткой и самой длинной первой строкой делается для того,
        // чтобы задать начальные значения для сравнения.
        String[] strings = {str1, str2, str3};

        String shortest = str1;
        String longest = str1;

        for (String string : strings) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
            if (string.length() > longest.length()) {
                longest = string;
            }

        }


        // Вывод результата
        System.out.println("Самая короткая строка: \"" + shortest + "\" (длина: " + shortest.length() + ")");
        System.out.println("Самая длинная строка: \"" + longest + "\" (длина: " + longest.length() + ")");


    }
}

