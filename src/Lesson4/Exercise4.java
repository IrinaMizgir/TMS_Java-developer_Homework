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
//Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
//сообщение, что их нет.
public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(numbers));
        int counter = 0;
        for (int number : numbers) {
            //System.out.println("Текущий элемент массива" + number);
            if (number == 0) {
                // System.out.println("Зашли в условие наш текущий равен = 0");
                counter++;
                //System.out.println("Наш счётчик равен " + counter);
            }
        }

        if (counter > 0) {
            System.out.println("Найдено " + counter + " нулевой(ых) элемент");
        } else {
            System.out.println("Не найдено нулевых элементов");
        }

    }
}

