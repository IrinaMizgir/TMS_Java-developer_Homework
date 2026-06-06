package Lesson1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Exercise1 {

    public static void main(String[] args) {
        //Написать приложение, которое будет вычислять и выводить значение по формуле:
        //a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.
        int b = 10;
        int c = 3;
        int firstResult = b + c - 1;
        int secondResult = 4 * firstResult;
        int result = secondResult / 2;
        System.out.println(result);
    }
}
