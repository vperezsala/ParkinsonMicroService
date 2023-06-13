package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import play.libs.Json;
import java.util.ArrayList;

public class SymptomService {
    private static SymptomService instance;
    private Map<Integer, Symptom> symptoms = new HashMap<>(){};


    public static SymptomService getInstance() {
        if (instance == null) {
            int i= 0;
            instance = new SymptomService();
            Symptom p1s1 = new Symptom(1, SymptomType.MOTOR_SYMPTOM, Symptoms.CHANGES_POSTURE_WALKING_OR_FACIAL_EXPRESSION);
            Symptom p1s2 = new Symptom(1, SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
            Symptom p2s1 = new Symptom(2, SymptomType.MOTOR_SYMPTOM, Symptoms.BRADYKINESIA);
            Symptom p2s2 = new Symptom(2, SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
            Symptom p3s1 = new Symptom(3, SymptomType.NON_MOTOR_SYMPTOM, Symptoms.HALLUCINATIONS);
            Symptom p3s2 = new Symptom(3, SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
            Symptom p3s3 = new Symptom(3, SymptomType.NON_MOTOR_SYMPTOM, Symptoms.GASTROINTESTINAL_UPSET );
            Symptom p4s1 = new Symptom(4, SymptomType.MOTOR_COMPLICATION, Symptoms.FUNCTIONAL_IMPACT_OFF_STATE);
            Symptom p4s2 = new Symptom(4, SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);
            Symptom p5s1 = new Symptom(5, SymptomType.MOTOR_SYMPTOM, Symptoms.POSTURAL_INSTABILITY);
            //Symptom p5s2 = new Symptom(5, SymptomType.NON_MOTOR_SYMPTOM, Symptoms.IMPULSE_CONTROL_DISORDERS);
            Symptom p5s3 = new Symptom(5, SymptomType.MOTOR_SYMPTOM, Symptoms.SPEECH_PROBLEM);
            Symptom p5s4 = new Symptom(5, SymptomType.NON_MOTOR_SYMPTOM, Symptoms.ANXIOUS);
            //Symptom p5s5 = new Symptom(5, SymptomType.MOTOR_COMPLICATION, Symptoms.LIVING_DEPENDENCY);
            Symptom p6s1 = new Symptom(6, SymptomType.MOTOR_COMPLICATION, Symptoms.BRADYKINESIA);
            Symptom p6s2 = new Symptom(6, SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
            Symptom p7s1 = new Symptom(7, SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);

            instance.addSymptom(p1s2);
            instance.addSymptom(p2s1);
            instance.addSymptom(p2s2);
            instance.addSymptom(p3s1);
            instance.addSymptom(p3s2);
            instance.addSymptom(p3s3);
            instance.addSymptom(p4s1);
            instance.addSymptom(p4s2);
            instance.addSymptom(p5s1);
            instance.addSymptom(p5s3);
            instance.addSymptom(p5s4);
            instance.addSymptom(p6s1);
            instance.addSymptom(p6s2);
            instance.addSymptom(p7s1);

        }
        return instance;
    }

    public Symptom addSymptom(Symptom symptom) {
        int symptomID = symptoms.size() + 1;
        symptom.setSymptomID(symptomID);
        symptoms.put(symptomID, symptom);
        return symptom;
    }

    public Symptom getSymptom(int symptomID) {
        return symptoms.get(symptomID);
    }
    public Set<Symptom> getSymptoms(int id){
        Set<Symptom> s = new  HashSet<>();
        Collection <Symptom> s1 = symptoms.values();
        for(Symptom symptom : s1){
            if( id == symptom.getPatient()) {
                int symptomID = symptom.getSymptomID();
                s.add(symptoms.get(symptomID));
            }
        }

        return s;
    }

    public Set<Symptom> getAllSymptoms() {
        return new HashSet<>(symptoms.values());
    }

    public Symptom updateSymptom(Symptom symptom) {
        int id = symptom.getSymptomID();
        if (symptoms.containsKey(id)) {
            symptoms.put(id, symptom);
            return symptom;
        }
        return null;
    }

    public boolean deleteSymptom(int symptomID) {
        return symptoms.remove(symptomID) != null;
    }

}