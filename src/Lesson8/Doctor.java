package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 25.03.2026 16:31
 */
public abstract class Doctor implements Treating {

    private final String name;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

