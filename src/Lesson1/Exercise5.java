package Lesson1;

public class Exercise5 {
    //В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
    //на экран результат деления q на w с остатком. Пример вывода программы (для случая,
    //когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке
    public static void main(String[] args) {
        int q = 17;
        int w = 5;
        int result = q / w;
        int mod = q % w;
        System.out.println(result + " и " + mod + " в остатке");
    }
}
