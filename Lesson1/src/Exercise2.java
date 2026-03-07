public class Exercise2 {

    public static void main(String[] args) {
        //В переменной n хранится двузначное число. Создайте программу, вычисляющую и
        //выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8
        //(2+6)
        int n = 97;
        int firstPart = n / 10;
        int secondPart = n % 10;
        int result = firstPart + secondPart;
        System.out.println(result);
    }
}
