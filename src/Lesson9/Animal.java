package Lesson9;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 15:10
 */
public interface Animal {

    /**
     * Подать голос.
     */
    void voice();

    /**
     * Есть еду.
     *
     * @param food (еда).
     */
    void eat(String food);

    /**
     * Получить имя животного.
     *
     * @return Имя животного.
     */
    String getName();
}
