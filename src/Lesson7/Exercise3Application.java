package Lesson7;

/**
 * @author Ирина Мизгир
 * @date 22.03.2026 14:21
 */
public class Exercise3Application {

    public static void main(String[] args) throws CloneNotSupportedException {
        Point point = new Point(20, 30);
        point.print();
        Point clone = point.clone();
        clone.print();
    }
}
