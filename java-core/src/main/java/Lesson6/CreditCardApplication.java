package Lesson6;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 21.03.2026 14:52
 */

//Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
//метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
//который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
//выводит текущую информацию о карточке. Напишите программу, которая создает три
//объекта класса CreditCard у которых заданы номер счета и начальная сумма.
//Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
//третьей. Выведите на экран текущее состояние всех трех карточек.

public class CreditCardApplication {

    public static void main(String[] args) {
        CreditCard pushokCreditCard = new CreditCard("4444555566667777", 1000, "PUSHOK");
        CreditCard jesseCreditCard = new CreditCard("9999111122223333", 1000, "JESSE");
        CreditCard skyCreditCard = new CreditCard("3333888877779999", 1000, "SKY");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму для первого счета ");
        skyCreditCard.addAmount(scan.nextDouble());
        //System.out.println("Текущая сумма у Скай " + skyCurrentCash);
        System.out.println("Введите сумму для второго счета ");
        pushokCreditCard.addAmount(scan.nextDouble());
        //System.out.println("Текущая сумма у Пушка " + pushokCurrentCash);
        System.out.println("Введите сумму для третьего счета ");
        jesseCreditCard.cashOut(scan.nextDouble());
        //System.out.println("Текущая сумма у Джесси " + jesseCurrentCash);
        skyCreditCard.printCardInfo();
        System.out.println("========");
        pushokCreditCard.printCardInfo();
        System.out.println("========");
        jesseCreditCard.printCardInfo();
        System.out.println("========");
    }

}
