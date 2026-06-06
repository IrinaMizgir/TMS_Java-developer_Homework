package project.model;

import java.nio.file.Path;
import java.util.List;

/**
 * Информация о текстовом файле.
 * @param path Путь к текстовому файлу.
 * @param lines Список линий текстового файла.
 * @author Ирина Мизгир
 * @date 25.04.2026 16:23
 */
public record TextFileInfo(List<String> lines, Path path) {

}
