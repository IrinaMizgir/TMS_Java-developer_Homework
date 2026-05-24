package lesson23;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 24.05.2026 17:50
 */

//Задача 1:
//Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
//содержимое тегов line записать в другой документ. Название файла для записи должно
//состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
// Задача *:
//Дополнительно реализовать следующий функционал: если с консоли введено значение 1
//- распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
//документ с помощью DOM

public class ExerciseApplication {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип парсинга 1 - с помощью SAX, 2 - с помощью DOM: ");
        ParseType parseType = ParseType.resolveParseTypeOrNull(scanner.nextInt());
        if (parseType == null) {
            System.out.println("Неизвестный тип парсинга");
            return;
        }
        URL url = ExerciseApplication.class.getClassLoader().getResource("\\Lesson23\\data.xml");
        var file = new File(Objects.requireNonNull(url, "Не найден файл").toURI());

        SonnetData data = resolveParser(parseType).parse(file);

        Path tempDirectory = Files.createTempDirectory("lesson23_");
        Path tempFile = Files.createFile(tempDirectory.resolve(data.getFirstName() + "_" + data.getLastName() + "_" + data.getTitle() + ".txt"));
        Files.write(tempFile, data.getLines());
        System.out.println("Разобранные данные: " + toConsolePath(tempFile));
    }

    /**
     * Сформирует путь для доступа к файлу из консоли.
     *
     * @param path Путь к файлу
     * @return Путь.
     */
    private static String toConsolePath(Path path) {
        return "file://" + path.toAbsolutePath().toString().replace("\\", "/");
    }

    /**
     * Разрешить парсер.
     *
     * @param parseType Тип парсера.
     * @return Парсер сонеты.
     */
    private static SonnetParser resolveParser(ParseType parseType) {
        return switch (parseType) {
            case SAX -> new SAXSonnetParser();
            case DOM -> new DOMSonnetParser();
        };
    }

    /**
     * Тип парсера.
     */
    private enum ParseType {

        SAX,
        DOM;

        /**
         * Разрешит тип парсера по введённому коду или вернет null.
         *
         * @param typeCode Код типа.
         * @return тип или null.
         */
        private static ParseType resolveParseTypeOrNull(int typeCode) {
            if (typeCode == 1) {
                return SAX;
            } else if (typeCode == 2) {
                return DOM;
            }
            return null;
        }

    }

}

