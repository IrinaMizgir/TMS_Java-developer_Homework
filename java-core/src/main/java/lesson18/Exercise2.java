package lesson18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ирина Мизгир
 * @date 29.04.2026 16:22
 */

//Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
//этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
//Среди отобранных значений отобрать только те, которые имеют нечетное количество
//букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.

public class Exercise2 {

    private static final Set<Integer> IDS = Set.of(1, 2, 5, 8, 9, 13);

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> names = List.of("Диана", "Мия", "Евгений", "Вадим", "Александр", "Елена", "Елизавета", "Людмила",
                "Дмитрий", "Валерия", "Арина", "Виктория", "Наталья");

        for (int i = 0; i < names.size(); i++) {
            map.put(i + 1, names.get(i));
        }

        List<String> reversedNames = map.entrySet().stream()
                .filter(idNameEntry -> IDS.contains(idNameEntry.getKey()))
                .map(Map.Entry::getValue)
                .filter(name -> name.length() % 2 == 1)
                .map(name -> new StringBuilder(name).reverse().toString())
                .toList();

        System.out.println(reversedNames);


    }
}
