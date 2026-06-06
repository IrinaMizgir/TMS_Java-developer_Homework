package Lesson4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 14.03.2026 12:15
 */
//Пользователь с клавиатуры вводит размер
//массива (просто целое число). После того как размер массива задан, заполнить его
//одним из двух способов: используя Math.random(), или каждый элемент массива вводится
//пользователем вручную. Попробовать оба варианта.
//Найти индексы минимального и максимального элементов и вывести в консоль.
public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        int min = 100;
        int max = 0;
        int minIndex = 0;
        int maxIndex = 0;
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < min) {
                min = number;
                minIndex = i;
            }
            if (number > max) {
                max = number;
                maxIndex = i;
            }


        }

        System.out.println("Минимум: " + min + " Минимальный индекс: " + minIndex);
        System.out.println("Максимум: " + max + " Максимальный индекс: " + maxIndex);
    }
}
