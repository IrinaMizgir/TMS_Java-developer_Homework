package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 25.03.2026 16:55
 */
public class Therapist extends Doctor {

    public Therapist() {
        super("Терапевт");
    }

    @Override
    public void treat() {
        System.out.println("Терапевт проводит общий осмотр и выписывает направления.");
    }

    public void acceptPatient(Patient patient) {
        int treatmentPlan = patient.getTreatmentPlan();
        if (treatmentPlan == 1) {
            Surgeon surgeon = new Surgeon();
            patient.setDoctor(surgeon);
            //patient.setDoctor(new Surgeon());
        } else if (treatmentPlan == 2) {
            Dentist dentist = new Dentist();
            patient.setDoctor(dentist);
            //patient.setDoctor(new Dentist());
        } else {
            patient.setDoctor(this);
        }
        patient.healing();
    }
}
