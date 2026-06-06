package Lesson15;

/**
 * @author Ирина Мизгир
 * @date 20.04.2026 12:58
 */
//Задача 2:
//Создать класс, который будет хранить в себе коллекцию с названиями животных.
//Реализовать методы удаления и добавления животных по следующим правилам:
//добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
//объекта этого класса в main методе другого класса.

public class Exercise2Application {

    public static void main(String[] args) {
        AnimalNames animalNames = new AnimalNames();
        animalNames.add("Собака");
        animalNames.add("Хомяк");
        animalNames.add("Змея");
        animalNames.print();
        animalNames.delete();
        animalNames.print();
    }
}
