package entities;

public class Prescription {
    private int patient;
    private boolean current;
    private Therapy therapy;
    private Treatment treatment;

    public Prescription(int patient) {

        this.patient = patient;
        this.treatment = Treatment.NO_TREATMENT;
    }

    public Prescription(int patient, Treatment treatment) {
        this.patient = patient;
        this.treatment = treatment;
        this.therapy = Therapy.NO_THERAPY;
    }
    public Prescription(int patient, Therapy therapy) {
        this.patient = patient;
        this.therapy = therapy;
        this.treatment = Treatment.NO_TREATMENT;
    }

    public Prescription(int patient, boolean current, Therapy therapy, Treatment treatment) {
        this.patient = patient;
        this.current = current;
        this.therapy = therapy;
        this.treatment = treatment;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "patient=" + patient +
                ", current=" + current +
                ", therapy=" + therapy +
                ", treatment=" + treatment +
                '}';
    }
}
