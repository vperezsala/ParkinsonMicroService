package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import play.libs.Json;

public class PatientService {
    private static PatientService instance;
    private Map<Integer, Patient> patients = new HashMap<>(){};


    public static PatientService getInstance() {
        Patient p1 = new Patient(1, "jorge", 70);
        Patient p2 = new Patient(2, "javier", 65);
        Patient p3 = new Patient(3, "isa", 70, true);
        Patient p4 = new Patient(4, "Maria", 74);
        Patient p5 = new Patient(5, "Juana", 69, true);
        Patient p6 = new Patient(6, "David", 55);
        Patient p7 = new Patient(7, "Caye", 70, true);

        if (instance == null) {
            instance = new PatientService();
            instance.patients.put(1,p1);
            instance.patients.put(2,p2);
            instance.patients.put(3,p3);
            instance.patients.put(4,p4);
            instance.patients.put(5,p5);
            instance.patients.put(6,p6);
            instance.patients.put(7,p7);

        }
        return instance;
    }

    public Patient addPatient(Patient patient) {
        int id = patients.size() + 1;
        patient.setId(id);
        patients.put(id, patient);
        return patient;
    }

    public Patient getPatient(int id) {
        return patients.get(id);
    }

    public Set<Patient> getAllPatients() {
        return new HashSet<>(patients.values());
    }

    public Patient updatePatient(Patient patient) {
        int id = patient.getId();
        if (patients.containsKey(id)) {
            patients.put(id, patient);
            return patient;
        }
        return null;
    }

    public boolean deletePatient(int id) {
        return patients.remove(id) != null;
    }

}