package by.tms.lesson23;

import java.util.ArrayList;
import java.util.List;

/**
 * Данные сонеты.
 * @author Ирина Мизгир
 * @date 24.05.2026 18:38
 */
public class SonnetData {
    /**
     * Имя.
     */
    private String firstName;
    /**
     * Фамилия.
     */
    private String lastName;
    /**
     * Название сонеты.
     */
    private String title;
    /**
     * Линии (строки сонеты).
     */
    private final List<String> lines = new ArrayList<>();

    /**
     * Добавляет линию (строку сонеты).
     */
    public void addLine(String line) {
        lines.add(line);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLines() {
        return lines;
    }
}
