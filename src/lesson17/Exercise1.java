package lesson17;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 29.04.2026 15:13
 */

//Задача 1:
//Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
//когда пользователю исполнится 100 лет. Использовать Date/Time API.

public class Exercise1 {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату своего рождения в формате (" + ANSI_GREEN + "yyyy-MM-dd" + ANSI_RESET + "): ");
        LocalDate date = LocalDate.parse(scanner.nextLine())
                .plusYears(100);

        System.out.println(date);
    }

}
