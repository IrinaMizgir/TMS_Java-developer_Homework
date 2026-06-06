package Lesson9;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 15:49
 */
public class Tiger extends AbstractAnimal {

    public Tiger() {
        super("Тигр");
    }

    @Override
    public void voice() {
        System.out.println(name + " рычит");
    }

    @Override
    protected boolean canEatFood(String food) {
        return "Meat".equals(food);
    }

    @Override
    protected void eatFood() {
        System.out.println(name + " люблю мяско");
    }
}
