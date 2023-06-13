package entities;

import java.util.List;

public class Patient {
    private int id;
    private String name;
    private int age;
    private boolean sideEffects;
    private boolean worsen;

    //private boolean alreadyTreated;

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
                ", sideEffects=" + sideEffects +
                ", worsen=" + worsen +
                '}';
    }
}

