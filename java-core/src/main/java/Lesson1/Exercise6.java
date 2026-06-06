package Lesson1;

public class Exercise6 {
    //Написать программу которая будет менять местами значение целочисленных
    //переменных. Пример:
    //int a = 1; int b = 2;

    /// /код (ваше решение)
    //sout(a); //выведет 2
    //sout(b); //выведет 1
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }
}
