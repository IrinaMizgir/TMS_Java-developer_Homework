package Lesson14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 18.04.2026 14:49
 */

//Допустим есть txt файл с номерами документов. Номером документа является строка,
//состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
//номер документа с новой строки и в строке никакой другой информации, только номер
//документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
//последовательности docnum(далее любая последовательность букв/цифр) или
//contract(далее любая последовательность букв/цифр). Написать программу для чтения
//информации из входного файла - путь к входному файлу должен задаваться через
//консоль. Программа должна проверять номера документов на валидность. Валидные
//номера документов следует записать в один файл-отчет. Невалидные номера документов
//следует записать в другой файл-отчет, но после номеров документов следует добавить
//информацию о том, почему этот документ не валиден.

public class Exercise2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        if (filePath.endsWith(".txt")) {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                List<String> fileLines = Files.readAllLines(path);
                Path validTempFile = Files.createTempFile("valid", ".txt");
                Path invalidTempFile = Files.createTempFile("invalid", ".txt");
                for (String line : fileLines) {
                    ValidateResult result = validate(line);
                    if (result.valid()) {
                        appendToFile(validTempFile, line);
                    } else {
                        appendToFile(invalidTempFile, line + " " + result.invalidMessage());
                    }
                }
                System.out.println("Валидные данные: file://" + toConsolePath(validTempFile));
                System.out.println("Невалидные данные: file://" + toConsolePath(invalidTempFile));
            } else {
                System.out.printf("\nФайл %s не существует\n", filePath);
            }

        } else {
            System.out.println("\nНеверный формат файла. Поддерживается только .txt");
        }

    }


    private static ValidateResult validate(String line) {
        if (line.isEmpty()) {
            return new ValidateResult(false, "Пустая строка");
        }
        if (line.length() != 15) {
            return new ValidateResult(false, "Неверное количество символов: " + line.length());
        }
        if (!line.startsWith("docnum") && !line.startsWith("contract")) {
            return new ValidateResult(false, "Название документа не начинается с верного префикса");
        }

        return new ValidateResult(true, "");
    }

    private static String toConsolePath(Path path) {
        return path.toAbsolutePath().toString().replace("\\", "/");
    }

    private static void appendToFile(Path path, String line) throws IOException {
        Files.writeString(path, line + "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    /**
     * Результат валидации.
     * (record класс в котором есть только конструктор и геттеры (без префикса get)).
     * @param valid результат валидации.
     * @param invalidMessage сообщение о невалидности.
     */
    private record ValidateResult(boolean valid, String invalidMessage) {

    }
}
