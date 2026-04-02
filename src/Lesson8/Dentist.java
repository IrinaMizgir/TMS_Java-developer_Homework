package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 25.03.2026 16:48
 */
public class Dentist extends Doctor {

    public Dentist() {
        super("Стоматолог");
    }

    @Override
    public void treat() {
        System.out.println("Стоматолог лечит зубы.");
    }
}
