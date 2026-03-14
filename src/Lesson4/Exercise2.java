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
//Найти минимальный-максимальный элементы и вывести в консоль.
public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        int maxNumber = 100;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * maxNumber);
        }
        int min = maxNumber;
        int max = 0;
        System.out.println(Arrays.toString(numbers));
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }

        }
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }
}

