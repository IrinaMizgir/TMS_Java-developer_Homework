package project.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Utility class для работы с консолью.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 15:54
 */
public final class ConsoleUtils {

    /**
     * Статический (singleton) экземпляр сканера.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleUtils() {

    }

    /**
     * Вернет папку по абсолютному пути.
     *
     * @param message Сообщение.
     * @return Путь к папке.
     */
    public static Path getFolderAsAbsolutePath(String message) {
        System.out.println(message);
        while (SCANNER.hasNextLine()) {
            String pathAsString = SCANNER.nextLine();
            if (pathAsString.isEmpty()) {
                System.out.println("Путь не может быть пустым.");
                continue;
            }
            Path path = Paths.get(pathAsString);
            if (!path.isAbsolute()) {
                System.out.println("Путь должен быть абсолютным.");
                continue;
            }
            if (Files.exists(path)) {
                if (Files.isDirectory(path)) {
                    return path;
                } else {
                    System.out.println("Веденный файл не является папкой");
                }
            } else {
                System.out.printf("%nПапки %s не существует%n", pathAsString);
            }
        }
        throw new RuntimeException(); //невозможно
    }

    /**
     * Печатает путь к файлу.
     *
     * @param messagePrefix Префикс сообщения.
     * @param filePath Путь к файлу.
     */
    public static void printPath(String messagePrefix, Path filePath) {
        System.out.println(messagePrefix + "file://" + filePath.toAbsolutePath().toString().replace("\\", "/"));
    }

    /**
     * Вернет объект из строки.
     *
     * @param message Сообщение.
     * @param mappingFunction Функция преобразования.
     * @param <T> Тип возвращаемого объекта.
     * @return Объект.
     */
    public static <T> T getFromString(String message, Function<String, T> mappingFunction) {
        System.out.println(message);

        while (SCANNER.hasNextLine()) {
            try {
                return mappingFunction.apply(SCANNER.nextLine());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }

        }

        throw new RuntimeException(); //невозможно
    }

    /**
     * Возращает дату.
     *
     * @param prefix Префикс сообщения.
     * @return Дата.
     */
    public static LocalDate getLocalDate(String prefix) {
        System.out.println(prefix + " в формате (YYYY-MM-DD):");
        while (SCANNER.hasNextLine()) {
            try {
                return LocalDate.parse(SCANNER.nextLine());
            } catch (RuntimeException exception) {
                System.out.println("Невозможно разобрать дату.");
            }
        }
        throw new RuntimeException(); //невозможно
    }
}
