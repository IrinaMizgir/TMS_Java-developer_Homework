package Lesson14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * @author Ирина Мизгир
 * @date 18.04.2026 14:48
 */

//В задании приложен файл сказки на белорусском языке "Кот Максим", вычитать его в приложении.
//Проанализировать и записать в другой файл самое длинное слово.

public class Exercise1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL textURLResource = Exercise1.class.getClassLoader().getResource("\\Lesson14\\text.txt");
        Objects.requireNonNull(textURLResource,"Не найден файл в пути к классам ");
        List<String> lines = Files.readAllLines(Path.of(textURLResource.toURI()));
        String largestWord = findLargestWord(lines);
        Path tempFilePath = Files.createTempFile("TMS", ".txt");
        Files.writeString(tempFilePath, largestWord, StandardCharsets.UTF_8);
        System.out.println("file://" + tempFilePath.toAbsolutePath().toString().replace("\\", "/"));
    }

    private static String findLargestWord(List<String> lines) {
        String largestWord = "";
        for (String line : lines) {
            String[] words = line.split("[^а-яА-ЯёЁіІўЎʼ\\-]+");
            for (String word : words) {
                if (word.length() > largestWord.length()) {
                    largestWord = word;
                }
            }
        }
        System.out.println("Самое длинное слово " + largestWord);
        return largestWord;
    }
}
