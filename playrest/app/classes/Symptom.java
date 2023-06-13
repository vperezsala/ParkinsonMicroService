package entities;

public class Symptom {
    private int patient;
    private int symptomID;
    private SymptomType type;
    private Symptoms symptom;


    public Symptom(int patient, SymptomType type) {
        this.patient = patient;
        this.type = type;
    }

    public Symptom(int patient, SymptomType type, Symptoms symptom) {
        this.patient = patient;
        this.type = type;
        this.symptom = symptom;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public int getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(int symptomID) {
        this.symptomID = symptomID;
    }

    public SymptomType getType() {
        return type;
    }

    public void setType(SymptomType type) {
        this.type = type;
    }

    public Symptoms getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptoms symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "patient=" + patient +
                ", type=" + type +
                ", symptom=" + symptom +
                '}';
    }
}
