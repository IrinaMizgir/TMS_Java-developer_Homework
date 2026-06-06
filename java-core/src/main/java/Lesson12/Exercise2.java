package Lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ирина Мизгир
 * @date 10.04.2026 17:21
 */
//Задача *:
//Программа на вход получает произвольный текст. В этом тексте может быть номер
//документа(один или несколько), емейл и номер телефона. Номер документа в формате:
//xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
//может содержать не всю информацию, т.е. например, может не содержать номер
//телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
//формате:
//email: teachmeskills@gmail.com
//document number: 1423-1512-51 и т.д
//Текст для теста: Мои данные: email: teachmeskills@gmail.com, документ: 1423-1512-51,
// Мои данные: email:teachmeskills@gmail.com, документ: 1423-1512-51, телефон +(29)3962616 телефон+(29)3962616

public class Exercise2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = input.nextLine();
        Pattern emailPattern = Pattern.compile("\\b[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        List<String> emails = new ArrayList<>();
        while (emailMatcher.find()) {
            emails.add(emailMatcher.group());
        }

        Pattern phonePattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        List<String> phones = new ArrayList<>();
        while (phoneMatcher.find()) {
            phones.add(phoneMatcher.group());
        }

        Pattern docNumPattern = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b");
        Matcher docNumMatcher = docNumPattern.matcher(text);
        List<String> docNums = new ArrayList<>();
        while (docNumMatcher.find()) {
            docNums.add(docNumMatcher.group());
        }

        if (!emails.isEmpty()) {
            System.out.println("\nEmails: " + emails);
        }
        if (!phones.isEmpty()) {
            System.out.println("\nPhones: " + phones);
        }
        if (!docNums.isEmpty()) {
            System.out.println("\nDoc Numbers: " + docNums);
        }

    }

}
