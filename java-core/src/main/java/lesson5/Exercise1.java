package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 15.03.2026 12:58
 */
//Задача 1:
//1.1 Создать двумерный массив, заполнить его случайными числами.
//1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
//1.3 Найти сумму всех получившихся элементов и вывести в консоль.

public class Exercise1 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][2];
        for (int index = 0; index < matrix.length; index++) {
            for (int nestedIndex = 0; nestedIndex < matrix[index].length; nestedIndex++) {
                matrix[index][nestedIndex] = (int) (Math.random() * 100);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число");
        int num = input.nextInt();
        for (int index = 0; index < matrix.length; index++) {
            for (int nestedIndex = 0; nestedIndex < matrix[index].length; nestedIndex++) {
                matrix[index][nestedIndex] = num + matrix[index][nestedIndex];
            }

        }
        System.out.println("Массив с добавлением числа " + num + " от пользователя " + Arrays.deepToString(matrix));
        int sum = 0;
        for (int[] nums : matrix) {
            for (int number : nums) {
                sum += number;
            }
        }
        System.out.println("Сумма всех элементов массива " + sum);
    }
}


