package Lesson6;

/**
 * @author Ирина Мизгир
 * @date 17.03.2026 13:36
 */

public class CreditCard {

    private final String accountNumber;

    private double currentAmount;

    private final String cardHolderName;

    public CreditCard(String accountNumber, double currentAmount, String cardHolderName) {
        this.accountNumber = accountNumber;
        this.currentAmount = currentAmount;
        this.cardHolderName = cardHolderName;
    }

    public void addAmount(double amount) {
        currentAmount += amount;
    }

    public void cashOut(double amount) {
        if (currentAmount < amount) {
            System.out.println("Недостаточно средств");
            System.out.println("Количество денег на счете " + currentAmount);
        } else {
            currentAmount -= amount;
        }
    }

    public void printCardInfo() {
        System.out.println("Имя держателя карты " + cardHolderName);
        System.out.println("Номер карты " + accountNumber);
        System.out.println("Сумма на счете " + currentAmount);
    }

}
