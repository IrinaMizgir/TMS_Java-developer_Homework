package Lesson7;

/**
 * @author Ирина Мизгир
 * @date 22.03.2026 00:38
 */
public abstract class Shape {

    /**
     * Рассчитывает площадь.
     *
     * @return Площадь фигуры.
     */
    public abstract double calculateArea();

    /**
     * Рассчитывает периметр.
     *
     * @return Периметр фигуры.
     */
    public abstract double calculatePerimeter();

    public static class Triangle extends Shape {
        private final double a;
        private final double b;
        private final double c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double calculateArea() {
            double semiPerimeter = (a + b + c) / 2; // Полупериметр
            return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }
    }

    public static class Square extends Shape {
        private final double a;

        public Square(double a) {
            this.a = a;
        }

        @Override
        public double calculateArea() {
            return a * a;
        }

        @Override
        public double calculatePerimeter() {
            return 4 * a;
        }
    }

    public static class Rectangle extends Shape {
        private final double a;
        private final double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double calculateArea() {
            return a * b;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (a + b);
        }
    }

    public static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }
}

