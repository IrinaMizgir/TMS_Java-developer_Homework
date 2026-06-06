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
//Проверить, является ли массив возрастающей последовательностью (каждое следующее
//число больше предыдущего).

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Введите значения для индекса " + i);
            numbers[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(numbers));
        int prevElement = numbers[0];
        boolean flag = true;
        for (int i = 1; i < numbers.length; i++) {
            if (prevElement > numbers[i]) {
                flag = false;
                break;
            }
            prevElement = numbers[i];
        }
        if (flag) {
            System.out.println("массив является возрастающей последовательностью");
        } else {
            System.out.println("массив не является возрастающей последовательностью");
        }

    }
}
