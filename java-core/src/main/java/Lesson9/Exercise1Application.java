package Lesson9;

import java.util.Scanner;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 16:01
 */
public class Exercise1Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Выбери еду (Meat, Grass)");
        Animal[] animals = {Dog.create(), new Rabbit(), new Tiger()};
        String[] foods = new String[animals.length];
        for (int i = 0; i < foods.length; i++) {
            System.out.println("Введите еду для " + animals[i].getName());
            foods[i] = input.nextLine();
        }
        for (int i = 0; i < animals.length; i++) {
            animals[i].eat(foods[i]);
        }
        for (Animal animal : animals) {
            animal.voice();
        }
    }
}
