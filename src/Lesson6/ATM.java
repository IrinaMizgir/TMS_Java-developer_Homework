package Lesson6;

/**
 * @author Ирина Мизгир
 * @date 21.03.2026 17:28
 */

public class ATM {

    /**
     * Количество 20 долларовых купюр
     */
    private int count20;

    /**
     * Количество 50 долларовых купюр
     */
    private int count50;

    /**
     * Количество 100 долларовых купюр
     */
    private int count100;

    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
    }

    public void add(int count20, int count50, int count100) {
        this.count20 += count20;
        this.count50 += count50;
        this.count100 += count100;

    }

    public boolean cashOut(int amount) {

        int cash = amount;
        if (amount % 10 != 0) {
            System.out.println("Неверная сумма " + cash);
            return false;
        }
        int currentCount100 = count100;
        int currentCount50 = count50;
        int currentCount20 = count20;
        int amount100 = 0;
        int amount50 = 0;
        int amount20 = 0;

        while (amount > 0) {
            if (currentCount100 > 0 && amount >= 100) {
                amount100 = Math.min(amount / 100, currentCount100);
                amount -= amount100 * 100;
                currentCount100 -= amount100;
            }
            if (currentCount50 > 0 && ((amount - 50) % 20 == 0 || amount % 50 == 0)) {
                amount50 = Math.min(amount / 50, currentCount50);
                amount -= amount50 * 50;
                currentCount50 -= amount50;
            }
            if (currentCount20 > 0) {
                amount20 = Math.min(amount / 20, currentCount20);
                amount -= amount20 * 20;
                currentCount20 -= amount20;
            }
            if (currentCount100 == 0 && currentCount50 == 0 && currentCount20 == 0) {
                break;
            }
            if (amount == 10) {
                break;
            }

        }

        if ((amount100 == count100 || amount50 == count50 || amount20 == count20) && amount > 0) {
            System.out.println("Недостаточно купюр");
            return false;
        }

        System.out.printf("Вам выдано %d 100 долларовых купюр, %d 50 долларовых купюр, %d 20 долларовых купюр %n", amount100, amount50, amount20);
        count100 -= amount100;
        count50 -= amount50;
        count20 -= amount20;
        return true;

    }
}


