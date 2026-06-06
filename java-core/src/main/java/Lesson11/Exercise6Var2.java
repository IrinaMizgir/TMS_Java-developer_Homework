package Lesson11;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 05.04.2026 17:13
 */
//Задача *:
//Дана строка произвольной длины с произвольными словами. Написать программу для
//проверки является ли любое выбранное слово в строке палиндромом.
//Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е
//слово в этой строке палиндромом.
//Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например,
//в строке 5 слов, а на вход программе передали число 500.

public class Exercise6Var2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String phrase = scanner.nextLine();
        System.out.print("Выберите позицию слова которое надо проверить: ");
        int position = scanner.nextInt();
        String[] words = phrase.split(" ");
        if (words.length >= position) {
            String word = words[position - 1];
            StringBuilder builder = new StringBuilder(word);
            if (word.contentEquals(builder.reverse())) {
                System.out.println("Слово " + "\"" + word + "\"" + " является палиндромом");
            } else {
                System.out.println("Палиндром не найден");
            }
        } else {
            System.out.println("Ошибка. Введена не верная позиция");
        }
    }
}
