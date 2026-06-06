package Lesson15;

import java.util.*;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 12:58
 */
//Задача 1:
//Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
//4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
//При решении использовать коллекции.

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите набор чисел: ");
        String[] numbersAsString = input.nextLine().split("[\\s,]+");
        Integer[] numbers = new Integer[numbersAsString.length];
        for (int i = 0; i < numbersAsString.length; i++) {
            String numberAsString = numbersAsString[i];
            try {
                numbers[i] = Integer.valueOf(numberAsString.trim());
            }  catch (NumberFormatException numberFormatException) {
                System.out.printf("Введено не верное значение %s (надо число).", numberAsString);
                return;
            }
        }
        Set<Integer> numbersAsSet = new LinkedHashSet<>(Arrays.asList(numbers));
        System.out.println(numbersAsSet);

    }
}
