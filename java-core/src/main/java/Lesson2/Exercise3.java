package Lesson2;

/**
 * @author Ирина Мизгир
 * @date 03.03.2026 19:12
 */
//Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.
public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Квадраты чисел от 10 до 20:");

        for (int i = 10; i <= 20; i++) {
            int square = i * i;
            System.out.println(i + "² = " + square);
        }
    }
}
