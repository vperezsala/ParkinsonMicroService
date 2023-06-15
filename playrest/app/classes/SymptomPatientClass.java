package entities;

public class SymptomPatientClass {
    private SymptomType type;
    private Symptoms symptomName;

    public SymptomPatientClass(){
    }

    public SymptomPatientClass(SymptomType type, Symptoms symptomName) {
        this.symptomName = symptomName;
        this.type = type;
    }

    public SymptomType getType() {
        return type;
    }

    public void setType(SymptomType type) {
        this.type = type;
    }

    public Symptoms getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(Symptoms symptomName) {
        this.symptomName = symptomName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Symptom{" +
                "type=" + type +
                ", symptom name=" + symptomName +
                '}';
    }
}