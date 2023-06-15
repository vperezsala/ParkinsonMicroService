package entities;

public class Disease {
    int patient;
    Previous_disease previous_disease;

    public Disease() {
    }
    public Disease(int patient) {
        this.patient = patient;
    }

    public Disease(int patient, Previous_disease previous_disease) {
        this.patient = patient;
        this.previous_disease = previous_disease;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public Previous_disease getPrevious_disease() {
        return previous_disease;
    }

    public void setPrevious_disease(Previous_disease previous_disease) {
        this.previous_disease = previous_disease;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "patient=" + patient +
                ", previous_disease=" + previous_disease +
                '}';
    }
}

