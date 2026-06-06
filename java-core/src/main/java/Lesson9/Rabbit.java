package Lesson9;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 15:52
 */
public class Rabbit extends AbstractAnimal {

    public Rabbit() {
        super("Кролик");
    }

    @Override
    public void voice() {
        System.out.println(name + " фыркает");
    }

    @Override
    protected boolean canEatFood(String food) {
        return "Grass".equals(food);
    }

    @Override
    protected void eatFood() {
        System.out.println(name + " люблю травку");
    }
}
