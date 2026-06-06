package Lesson16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 21.04.2026 18:15
 */

//Задача 2
//На вход поступает массив непустых строк, создайте и верните Map<String,
//String> следующим образом: для каждой строки добавьте ее первый символ в
//качестве ключа с последним символом в качестве значения. Пример:
//pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//pairs(["man", "moon", "main"]) → {"m": "n"}
//pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}

public class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arraySize = Integer.parseInt(scanner.nextLine());
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Введите строку: ");
            array[i] = scanner.nextLine();
        }
        Map<String, String> map = new HashMap<>();
        for (String string : array) {
            map.put(Character.toString(string.charAt(0)), Character.toString(string.charAt(string.length()-1)));
        }
        System.out.println(map);
    }
}
