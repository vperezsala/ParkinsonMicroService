package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import play.libs.Json;
import java.util.List;
import java.util.ArrayList;

public class PatientService {
    private static PatientService instance;
    private Map<Integer, Patient> patients = new HashMap<>(){};


    public static PatientService getInstance() {

        List<Previous_disease> previousDiseaseList = new ArrayList<>();

        Patient p1 = new Patient(1, "jorge", 70);
        Treatment t1 = Treatment.NO_TREATMENT;
        p1.setCurrent_treatment(t1);
        List<SymptomPatientClass> s = new ArrayList<>();
        SymptomPatientClass p1s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.CHANGES_POSTURE_WALKING_OR_FACIAL_EXPRESSION);
        SymptomPatientClass p1s2 = new SymptomPatientClass(SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        s.add(p1s1);
        s.add(p1s2);
        p1.setSymptoms(s);


        Patient p2 = new Patient(2, "javier", 65);
        Treatment t2 = Treatment.NO_TREATMENT;
        p2.setCurrent_treatment(t2);
        List<SymptomPatientClass> s2 = new ArrayList<>();
        SymptomPatientClass p2s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.BRADYKINESIA);
        SymptomPatientClass p2s2 = new SymptomPatientClass(SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
        s2.add(p2s1);
        s2.add(p2s2);
        p2.setSymptoms(s2);



        Patient p3 = new Patient(3, "isa", 70, true);
        Treatment t3 = Treatment.MAO_B_INHIBITORS;
        p3.setCurrent_treatment(t3);
        List<SymptomPatientClass> s3 = new ArrayList<>();
        SymptomPatientClass p3s1 = new SymptomPatientClass( SymptomType.NON_MOTOR_SYMPTOM, Symptoms.HALLUCINATIONS);
        SymptomPatientClass p3s2 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
        SymptomPatientClass p3s3 = new SymptomPatientClass( SymptomType.NON_MOTOR_SYMPTOM, Symptoms.GASTROINTESTINAL_UPSET );
        s3.add(p3s1);
        s3.add(p3s2);
        s3.add(p3s3);
        p3.setSymptoms(s3);



        Patient p4 = new Patient(4, "Maria", 74);
        Treatment t4 = Treatment.LEVODOPA;
        p4.setCurrent_treatment(t4);
        List<SymptomPatientClass> s4 = new ArrayList<>();
        SymptomPatientClass p4s1 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.FUNCTIONAL_IMPACT_OFF_STATE);
        SymptomPatientClass p4s2 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);
        s4.add(p4s1);
        s4.add(p4s2);
        p4.setSymptoms(s4);



        Patient p5 = new Patient(5, "Juana", 69, true);
        Treatment t5 = Treatment.DOPAMINE_AGONISTS;
        p5.setCurrent_treatment(t5);
        List<SymptomPatientClass> s5 = new ArrayList<>();
        SymptomPatientClass p5s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.POSTURAL_INSTABILITY);
        //SymptomPatientClass p5s2 = new SymptomPatientClass( SymptomType.NON_MOTOR_SYMPTOM, Symptoms.IMPULSE_CONTROL_DISORDERS);
        SymptomPatientClass p5s3 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.SPEECH_PROBLEM);
        SymptomPatientClass p5s4 = new SymptomPatientClass( SymptomType.NON_MOTOR_SYMPTOM, Symptoms.ANXIOUS);
        //SymptomPatientClass p5s5 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.LIVING_DEPENDENCY);
        s5.add(p5s1);
        s5.add(p5s3);
        s5.add(p5s4);
        p5.setSymptoms(s5);



        Patient p6 = new Patient(6, "David", 55);
        Treatment t6 =  Treatment.DOPAMINE_AGONISTS;
        p6.setCurrent_treatment(t6);
        Previous_disease p6d1 = Previous_disease.DIABETES;
        previousDiseaseList.add(p6d1);
        p6.setPrevious_diseases(previousDiseaseList);
        List<SymptomPatientClass> s6 = new ArrayList<>();
        SymptomPatientClass p6s1 = new SymptomPatientClass(SymptomType.MOTOR_COMPLICATION, Symptoms.BRADYKINESIA);
        SymptomPatientClass p6s2 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        s6.add(p6s1);
        s6.add(p6s2);
        p6.setSymptoms(s6);


        Patient p7 = new Patient(7, "Caye", 70, true);
        Treatment t7 = Treatment.LEVODOPA;
        p7.setCurrent_treatment(t7);
        List<SymptomPatientClass> s7 = new ArrayList<>();
        SymptomPatientClass p7s1 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);
        s7.add(p7s1);
        p7.setSymptoms(s7);


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

    public Patient updatePatient(Patient patient, int id) {
        if (patients.containsKey(id)) {
            patients.put(id, patient);
            return patient;
        }
        return null;
    }
    /*
    public Patient addSymptom(int id, SymptomPatientClass symptom) {
        Patient patient = patients.get(id);
        patient.getSymptoms().add(symptom);
        patients.put(id, patient);
        return patient;
    }
    public Patient addPrevious_disease(int id, Previous_disease previousDisease) {
        Patient patient = patients.get(id);
        patient.getPrevious_diseases().add(previousDisease);
        patients.put(id, patient);
        return patient;
    }
*/
    public boolean deletePatient(int id) {
        return patients.remove(id) != null;
    }

}