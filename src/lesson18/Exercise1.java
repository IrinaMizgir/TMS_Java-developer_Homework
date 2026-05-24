package lesson18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ирина Мизгир
 * @date 29.04.2026 16:11
 */

//Задача 1:
//Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
//Stream'ов:
//- Удалить дубликаты
//- Оставить только четные элементы
//- Вывести сумму оставшихся элементов в стриме

public class Exercise1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 10);
        int sum = list.stream()
                .mapToInt(i -> i)
                .distinct()
                .filter(x -> x % 2 == 0)
                .sum();

        System.out.println(sum);

    }

}
