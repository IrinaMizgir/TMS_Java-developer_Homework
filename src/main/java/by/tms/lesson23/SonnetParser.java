package by.tms.lesson23;

import java.io.File;
import java.io.IOException;

/**
 * Парсер сонеты.
 *
 * @author Ирина Мизгир
 * @date 24.05.2026 18:43
 */
public interface SonnetParser {

    /**
     * Парсинг файла.
     *
     * @param file Файл.
     * @return Данные сонеты.
     *
     */
    SonnetData parse(File file) throws IOException;
}
