package Lesson9;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 15:11
 */
public abstract class AbstractAnimal implements Animal {

    protected final String name;

    protected AbstractAnimal(String name) {
        this.name = name;
    }

    @Override
    public void eat(String food) {
        if (canEatFood(food)) {
            eatFood();
        } else {
            System.out.println(name + " недоволен");
        }
    }

    /**
     * Проверит, может ли животное есть еду.
     *
     * @param food (переданная еда для проверки).
     * @return результат проверки.
     */
    protected abstract boolean canEatFood(String food);

    /**
     * Метод для поедания еды различными животными.
     */
    protected abstract void eatFood();

    @Override
    public String getName() {
        return name;
    }
}
