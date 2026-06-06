package by.tms.lesson20;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 13:52
 */

//Задача 1:
//Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
//потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
//вычислений возвращаются в метод main().

public class Exercise1 {

    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        var array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Введите число: ");
            array[i] = scanner.nextInt();
        }
        var maxThread = new Thread(() -> Arrays.stream(array)
                .max()
                .ifPresent(value -> System.out.println("Поток: " + Thread.currentThread().getName() + " Максимум: " + value))
        );
        var minThread = new Thread(() -> Arrays.stream(array)
                .min()
                .ifPresent(value -> System.out.println("Поток: " + Thread.currentThread().getName() + " Минимум: " + value))
        );
        maxThread.start();
        minThread.start();
        maxThread.join();
        minThread.join();
    }
}
