package Lesson13;

/**
 * @author Ирина Мизгир
 * @date 11.04.2026 14:43
 */
//Задача *:
//Написать try/catch/finally, в котором finally вызван не будет.

public class Exercise2 {

    public static void main(String[] args) {
        try {
            System.exit(0); // завершает работу JVM
        } catch (RuntimeException runtimeException) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Block finally");
        }
    }
}
