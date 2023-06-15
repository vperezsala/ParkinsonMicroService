package entities;

import java.util.List;

public class Patient {
    private int id;
    private String name;
    private int age;
    private List<SymptomPatientClass> symptoms;
    private List<Previous_disease> previous_diseases;
    private Treatment current_treatment;
    private boolean sideEffects;
    private boolean worsen;

    public Patient() {
    }
    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Patient(int id, String name, int age, boolean worsen) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.worsen = worsen;
    }

    public List<SymptomPatientClass> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SymptomPatientClass> symptoms) {
        this.symptoms = symptoms;
    }

    public List<Previous_disease> getPrevious_diseases() {
        return previous_diseases;
    }

    public void setPrevious_diseases(List<Previous_disease> previous_diseases) {
        this.previous_diseases = previous_diseases;
    }

    public Treatment getCurrent_treatment() {
        return current_treatment;
    }

    public void setCurrent_treatment(Treatment current_treatment) {
        this.current_treatment = current_treatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(boolean sideEffects) {
        this.sideEffects = sideEffects;
    }

    public boolean isWorsen() {
        return worsen;
    }

    public void setWorsen(boolean worsen) {
        this.worsen = worsen;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", symptoms=" + symptoms +
                ", previous_diseases=" + previous_diseases +
                ", current_treatment=" + current_treatment +
                ", sideEffects=" + sideEffects +
                ", worsen=" + worsen +
                '}';
    }
}

