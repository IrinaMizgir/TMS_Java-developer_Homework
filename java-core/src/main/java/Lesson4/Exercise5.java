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
//Пройти по массиву и поменять местами элементы первый и последний, второй и
//предпоследний и т.д.
public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length / 2; i++) {
            //System.out.println("Начало прогона "+i);
            // System.out.println(numbers[i]); //вывели пол длины массива
            //System.out.println(numbers[numbers.length - i - 1]);
            int temp = numbers[i];
            //System.out.println("Значение временной переменной " + temp);
            int indexFromEnd = numbers.length - i - 1;
            //System.out.println("Значение элемента массива " + numbers[indexFromEnd] + " по индексу " + indexFromEnd);
            numbers[i] = numbers[indexFromEnd];//происходит тусовка значений
            numbers[indexFromEnd] = temp;
            //System.out.println("Текущий элемент массива с начала " + numbers[i] + " по индексу " + i);
            //System.out.println("Текущий элемент массива с конца " + numbers[indexFromEnd] + " по индексу " + indexFromEnd);
            //System.out.println("Конец прогона "+i);
            //System.out.println("Как сейчас выглядит массив "+ Arrays.toString(numbers));
        }
        System.out.println(Arrays.toString(numbers));


    }
}
//Сделана при помощи гугла, молитв и слез.
