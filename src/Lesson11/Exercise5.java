package Lesson11;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 02.04.2026 15:59
 */

//Вывести на консоль новую строку, которой задублирована каждая буква из
//начальной строки. Например, "Hello" -> "HHeelllloo".

public class Exercise5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String original = scanner.nextLine();

        StringBuilder result = new StringBuilder();


        for (char c : original.toCharArray()) { // преобразует строку original в массив символов.
            result.append(c).append(c);
            //Добавляет текущий символ c в result два раза подряд.
        }

        System.out.println("Результат: " + result);
    }
}
