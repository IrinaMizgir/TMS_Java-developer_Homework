package by.tms.lesson17;

import java.util.function.Predicate;

/**
 * @author Ирина Мизгир
 * @date 29.04.2026 15:25
 */

//Задача 2:
//Используя Predicate среди массива чисел вывести только те, которые являются
//положительными.

public class Exercise2 {

    public static void main(String[] args) {
        int[] numbers = {-1, -2, 3, 4, 5, 6, -7, 8, -9, 10, -11, 12, 13, 14, 15};
        Predicate<Integer> isPositive = x -> x > 0;
        for (int number : numbers) {
            if (isPositive.test(number)) {
                System.out.println(number);
            }
        }
    }
}
