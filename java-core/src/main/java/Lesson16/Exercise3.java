package Lesson16;

import java.util.*;

/**
 * @author Ирина Мизгир
 * @date 21.04.2026 18:16
 */

//Задача *:
//Задана строка, которая может иметь внутри себя скобки. Скобкой считается
//любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
//сбалансированность расстановки скобок в этой строке. Набор скобок считается
//сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
//соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
//содержащая пары скобок, не сбалансирована, если набор заключенных в нее
//скобок не совпадает.
//Например, если ввод «{[(])}», пара квадратных скобок «[]» заключает в себя
//одну несбалансированную открывающую круглую скобку «(». Аналогично, пара
//круглых скобок «() ", заключает в себя одну несбалансированную
//закрывающую квадратную скобку "]". Таким образом, входная строка "{[(])}"
//несбалансированная.
//Пример
//() - сбалансирована
//[()] - сбалансирована
//{[()]} - сбалансирована
//([{{[(())]}}]) - сбалансирована
//{{[]()}}}} - не сбалансирована
//{[(])} - не сбалансирована

public class Exercise3 {

    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = stringScanner.nextLine();
        if (checkString(string)) {
            System.out.println("Сбалансирована");
        } else {
            System.out.println("Не сбалансирована");
        }

    }

    private static boolean checkString(String string) {
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (char stringChar : string.toCharArray()) {
            if (!map.containsKey(stringChar) && !map.containsValue(stringChar)) {
                continue;
            }
            if (map.containsKey(stringChar)) {
                stack.push(stringChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character closeBrace = map.get(stack.pop());
                if (!closeBrace.equals(stringChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
