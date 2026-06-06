package lesson20;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Ирина Мизгир
 * @date 10.05.2026 14:18
 */

//Задача 2:
//Сортировка массива цифр в нескольких потоках различными алгоритмами:
// сортировка вставками;
// сортировка выбором;
// сортировка пузырьком.
//Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
//результат отсортированных массивов в консоль.

public class Exercise2 {

    public static void main(String[] args) throws InterruptedException {
        var random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10); // цифры от 0 до 9
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("=".repeat(83));

        var insertionSortThread = new Thread(() -> {
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            for (int i = 1; i < arrayCopy.length; i++) {
                int key = arrayCopy[i]; // Текущий элемент
                int j = i - 1;

                // Сдвигаем элементы, которые больше key, на одну позицию вправо
                while (j >= 0 && arrayCopy[j] > key) {
                    arrayCopy[j + 1] = arrayCopy[j];
                    j--;
                }
                arrayCopy[j + 1] = key; // Вставляем key
            }
            System.out.println("Сортировка вставками: " + Arrays.toString(arrayCopy));
        });
        insertionSortThread.start();

        var selectionSortThread = new Thread(() -> {
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arrayCopy.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arrayCopy.length; j++) {
                    if (arrayCopy[j] < arrayCopy[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arrayCopy[minIndex];
                arrayCopy[minIndex] = arrayCopy[i];
                arrayCopy[i] = temp;
            }
            System.out.println("Сортировка выбором: " + Arrays.toString(arrayCopy));
        });
        selectionSortThread.start();

        var bubbleSortThread = new Thread(() -> {
            int[] arrayCopy = Arrays.copyOf(array, array.length);
            for (int i = 0; i < arrayCopy.length - 1; i++) {
                for (int j = 0; j < arrayCopy.length - i - 1; j++) {
                    // Сравнение соседних элементов
                    if (arrayCopy[j] > arrayCopy[j + 1]) {
                        // Обмен элементов местами
                        int temp = arrayCopy[j];
                        arrayCopy[j] = arrayCopy[j + 1];
                        arrayCopy[j + 1] = temp;
                    }
                }
            }
            System.out.println("Сортировка пузырьком: " + Arrays.toString(arrayCopy));
        });
        bubbleSortThread.start();
        insertionSortThread.join();
        selectionSortThread.join();
        bubbleSortThread.join();
    }
}


