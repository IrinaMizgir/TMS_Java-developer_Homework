package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 25.03.2026 16:41
 */
class Surgeon extends Doctor {

    public Surgeon() {
        super("Хирург");
    }

    @Override
    public void treat() {
        System.out.println("Хирург проводит операцию.");
    }
}