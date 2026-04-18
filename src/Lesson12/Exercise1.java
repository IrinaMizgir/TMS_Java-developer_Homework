package Lesson12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ирина Мизгир
 * @date 10.04.2026 17:05
 */

//Вывести в консоль из строки которую пользователь вводит с клавиатуры все аббревиатуры.
// Аббревиатурой будем считать слово от 2 до 6 символов, состоящее только из прописных букв, без чисел.

public class Exercise1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            // Регулярное выражение:
            // \b - граница слова
            // [A-ZА-ЯЁ] - заглавные буквы (латиница и кириллица)
            // {2,6} - длина от 2 до 6 символов

            Pattern pattern = Pattern.compile("\\b[A-ZА-ЯЁ]{2,6}\\b");

            Matcher matcher = pattern.matcher(input); //строка, которая создает matcher (сопоставитель)
            // для поиска всех аббревиатур в тексте.


            boolean found = matcher.find();
            if (found) {
                System.out.println("Найденные аббревиатуры:");
                System.out.println(matcher.group());
            }

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            if (!found) {
                System.out.println("Аббревиатуры не найдены.");
            }
        }

    }
}

