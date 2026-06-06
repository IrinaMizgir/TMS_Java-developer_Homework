package Lesson16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 21.04.2026 18:13
 */

//Задача 1:
//На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//2 или более раз. Пример:
//wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//wordMultiple(["c", "c", "c", "c"]) → {"c": true}

public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arraySize = Integer.parseInt(scanner.nextLine());
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Введите строку: ");
            array[i] = scanner.nextLine();
        }
        Map<String, Boolean> map = new HashMap<>();

        for (String string : array) {
            map.put(string, map.containsKey(string));
        }
        System.out.println(map);
    }
}
