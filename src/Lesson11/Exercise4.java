package Lesson11;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 02.04.2026 15:59
 */

//Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//Если таких слов несколько, найти первое из них.

public class Exercise4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();
        System.out.print("Введите третью строку: ");
        String str3 = scanner.nextLine();

        String[] strings = {str1, str2, str3};
        String foundString = null;
        for (String string : strings) {
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (string.indexOf(chars[i], i + 1) != -1) {
                    break;
                }
                if (i == chars.length - 1) {
                    foundString = string;
                    break;
                }
            }
            if (foundString != null) {
                break;
            }
        }
        System.out.println(Objects.requireNonNullElse(foundString, "Не найдено"));
    }
}
