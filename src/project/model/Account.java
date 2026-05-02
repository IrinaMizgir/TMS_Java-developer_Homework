package project.model;

/**
 * Счёт.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 13:30
 */
public class Account {
    /**
     * Номер счёта.
     */
    private final String number;
    /**
     * Баланс на счёте.
     */
    private double balance;

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Проверка баланса.
     *
     * @param balance Проверяемый баланс.
     * @return true если баланс больше или равен проверяемого.
     */
    public boolean checkBalance(double balance) {
        return this.balance >= balance;
    }

    /**
     * Снять сумму со счёта.
     *
     * @param sum Сумма для снятия.
     */
    public void subtractSum(double sum) {
        this.balance -= sum;
    }

    /**
     * Зачислить сумму на счёт.
     *
     * @param sum Сумма для зачисления.
     */
    public void addSum(double sum) {
        this.balance += sum;
    }
}
