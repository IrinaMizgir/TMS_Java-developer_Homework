package Lesson1;

public class Exercise3 {
    public static void main(String[] args) {
        //В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
        //выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
        //9 (1+2+6).
        int n = 123;
        int firstPart = n / 100;
        int mod = n % 100;
        int secondPart = mod / 10;
        int thirdPart = n % 10;
        int result = firstPart + secondPart + thirdPart;
        System.out.println(result);
    }
}
