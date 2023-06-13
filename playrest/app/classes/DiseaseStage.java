package entities;
public class DiseaseStage {
    private int patient;
    private Stage stage;

    public DiseaseStage(){
    }
    public DiseaseStage(int patient, Stage stage) {
        this.patient = patient;
        this.stage = stage;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "DiseaseStage{" +
                "patient=" + patient +
                ", stage=" + stage +
                '}';
    }
}
