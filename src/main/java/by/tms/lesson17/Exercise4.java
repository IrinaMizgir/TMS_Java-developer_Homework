package by.tms.lesson17;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Consumer;


/**
 * @author Ирина Мизгир
 * @date 29.04.2026 15:31
 */

//Задача 4:
//Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
//формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
//выводить сумму, переведенную сразу в доллары.

public class Exercise4 {

    private static final BigDecimal RATE = BigDecimal.valueOf(2.8201); // курс доллара на 29.04.2026

    public static void main(String[] args) {
        String value = "2000 BYN";
        Consumer<String> consumer = string -> {
            String[] split = string.split(" ");
            double sumInUSD = new BigDecimal(Double.parseDouble(split[0]))
                    .setScale(2, RoundingMode.HALF_UP)
                    .divide(RATE, RoundingMode.HALF_UP)
                    .doubleValue();

            System.out.println(sumInUSD + " USD");

        };

        consumer.accept(value);
    }
}
