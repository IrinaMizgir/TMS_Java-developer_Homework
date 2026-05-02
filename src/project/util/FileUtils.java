package project.util;

import project.MainRunner;
import project.exceptions.ClassPathResourceNotFound;
import project.model.TextFileInfo;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Utility-клвсс для работы с файлами.
 *
 * @author Ирина Мизгир
 * @date 23.04.2026 13:42
 */
public final class FileUtils {

    private FileUtils() {

    }

    /**
     * Загрузит текстовый ресурс из пути к классам как список линий.
     *
     * @param fileName Имя файла для загрузки.
     * @return Список строк (линий).
     */
    public static List<String> loadClassPathResourceAsLinesList(String fileName) {
        URL textURLResource = MainRunner.class.getClassLoader().getResource(File.separatorChar + "project" + File.separatorChar + fileName);
        Objects.requireNonNull(textURLResource, () -> "Не найден файл %s в пути к классам ".formatted(fileName));
        try {
            return readAllLinesFromPath(Path.of(textURLResource.toURI()));
        } catch (URISyntaxException | UncheckedIOException exception) {
            throw new ClassPathResourceNotFound(exception);
        }
    }

    /**
     * Прочитает данные из текстовых файлов и соберет их в список строк из определенной папки.
     *
     * @param inputDirectoryPath Папка.
     * @return Информацию о текстовых файлах.
     */
    public static List<TextFileInfo> loadTextFiles(Path inputDirectoryPath) {
        try (Stream<Path> stream = Files.list(inputDirectoryPath)) {
            return stream.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".txt"))
                    .map(FileUtils::createTextFileInfo)
                    .toList();
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    /**
     * Создаст обЪект с информацией о текстовом файле.
     *
     * @param path Путь к текстовому файлу.
     * @return Информация о текстовом файле.
     */
    private static TextFileInfo createTextFileInfo(Path path) {
        return new TextFileInfo(readAllLinesFromPath(path), path);
    }

    /**
     * Прочитает все линии из файла по пути.
     *
     * @param path Путь к файлу.
     * @return Список строк (линий).
     */
    public static List<String> readAllLinesFromPath(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

    }

    /**
     * Запишет список линий в файл.
     *
     * @param path Путь к файлу.
     * @param lines Список линий.
     */
    public static void writeAllLinesToPath(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    /**
     * Добавит список линий в файл.
     *
     * @param path Путь к файлу.
     * @param lines Список линий.
     */
    public static void appendAllLinesToPath(Path path, List<String> lines) {
        try {
            Files.write(path, lines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    /**
     * Переносит файл в папку.
     * @param source Путь источника.
     * @param destination Путь назначения.
     */
    public static void moveFileToDirectoryWithUniqueName(Path source, Path destination) {
        try {
            String destinationFileName = UUID.randomUUID() + "_" + source.getFileName().toString();
            Files.move(source, Files.createDirectories(destination).resolve(destinationFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    /**
     * Запись линий во временный файл.
     * @param prefix Префикс файла.
     * @param lines Список линий.
     * @return Путь к временному файлу.
     */
    public static Path writeLinesToTempTextFile(String prefix, List<String> lines) {
        try {
            Path tempFilePath = Files.createTempFile(prefix, ".txt");
            writeAllLinesToPath(tempFilePath, lines);
            return tempFilePath;
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

}
