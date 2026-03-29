package Lesson9;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 15:17
 */
//Задача *:
//Написать такой конструктор, который запретит создание объекта класса Dog в других
//классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
//обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
//способа.
public class Dog extends AbstractAnimal {

    private Dog() { //Написала приватный конструктор.
        super("Пёс");
    }


    @Override
    public void voice() {
        System.out.println(name + " лает");
    }

    @Override
    protected boolean canEatFood(String food) {
        return "Meat".equals(food);
    }

    @Override
    protected void eatFood() {
        System.out.println(name + " люблю мяско");
    }

    /**
     * Статический метод для класса {@link Dog}. Который позволяет вызывать приватный конструктор внутри этого класса.
     * Так как этот метод находиться внутри класса {@link Dog} он имеет доступ к приватному конструктору.
     *
     * @return Dog
     */
    public static Dog create() { //Способ вызывать методы voice(), eat() класса Dog.
        return new Dog();
    }

}
