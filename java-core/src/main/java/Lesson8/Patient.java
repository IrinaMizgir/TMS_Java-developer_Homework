package Lesson8;

/**
 * @author Ирина Мизгир
 * @date 29.03.2026 12:57
 */
public class Patient {

    private final int treatmentPlan;
    private Doctor doctor;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void healing() {
        doctor.treat();
    }
}
