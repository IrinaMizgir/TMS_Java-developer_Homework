package Lesson4;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 14.03.2026 12:15
 */
//Пользователь с клавиатуры вводит размер
//массива (просто целое число). После того как размер массива задан, заполнить его
//одним из двух способов: используя Math.random(), или каждый элемент массива вводится
//пользователем вручную. Попробовать оба варианта.
//Пройти по массиву, вывести все элементы в прямом и в обратном порядке.
public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.println("Прямой");
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println("Обратный");
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers.length - i - 1;
            System.out.println(numbers[a]);
        }
    }
}
