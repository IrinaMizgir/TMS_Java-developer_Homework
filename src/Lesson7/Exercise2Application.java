package Lesson7;

/**
 * @author Ирина Мизгир
 * @date 22.03.2026 00:33
 */

//Задача 2:
//Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг, Квадрат.
//Реализовать функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
//абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
//периметра всех фигур в массиве.

public class Exercise2Application {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Shape.Triangle(5, 5, 5),
                new Shape.Circle(5),
                new Shape.Rectangle(7, 5),
                new Shape.Square(4),
                new Shape.Triangle(7, 7, 7)
        };
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculatePerimeter();
        }
        System.out.println("Сумма периметра всех фигур в массиве " + sum);
    }
}
