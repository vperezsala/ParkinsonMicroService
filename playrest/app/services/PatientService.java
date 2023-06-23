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



        Patient p1 = new Patient(1, "Jorge Sánchez", 70);
        Treatment t1 = Treatment.NO_TREATMENT;
        p1.setCurrent_treatment(t1);
        List<SymptomPatientClass> s = new ArrayList<>();
        SymptomPatientClass p1s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.CHANGES_POSTURE_WALKING_OR_FACIAL_EXPRESSION);
        SymptomPatientClass p1s2 = new SymptomPatientClass(SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        s.add(p1s1);
        s.add(p1s2);
        p1.setSymptoms(s);


        Patient p2 = new Patient(2, "Javier Esteban", 81);
        Treatment t2 = Treatment.NO_TREATMENT;
        p2.setCurrent_treatment(t2);
        List<SymptomPatientClass> s2 = new ArrayList<>();
        SymptomPatientClass p2s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.BRADYKINESIA);
        SymptomPatientClass p2s2 = new SymptomPatientClass(SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        SymptomPatientClass p2s3 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.TREMOR);
        SymptomPatientClass p2s4 = new SymptomPatientClass(SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
        s2.add(p2s1);
        s2.add(p2s2);
        s2.add(p2s3);
        s2.add(p2s4);
        p2.setSymptoms(s2);
        List<Previous_disease> previousDiseaseList1 = new ArrayList<>();
        Previous_disease p2d1 = Previous_disease.HISTORY_OF_GLAUCOMA;
        previousDiseaseList1.add(p2d1);
        p2.setPrevious_diseases(previousDiseaseList1);



        Patient p3 = new Patient(3, "Isabelle Ollivier", 70, true);
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



        Patient p4 = new Patient(4, "Maria Alonso", 74);
        Treatment t4 = Treatment.LEVODOPA;
        p4.setCurrent_treatment(t4);
        List<SymptomPatientClass> s4 = new ArrayList<>();
        SymptomPatientClass p4s1 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.FUNCTIONAL_IMPACT_OFF_STATE);
        SymptomPatientClass p4s2 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);
        s4.add(p4s1);
        s4.add(p4s2);
        p4.setSymptoms(s4);



        Patient p5 = new Patient(5, "Juana Zabala", 69, true);
        Treatment t5 = Treatment.DOPAMINE_AGONISTS;
        p5.setCurrent_treatment(t5);
        List<SymptomPatientClass> s5 = new ArrayList<>();
        SymptomPatientClass p5s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.POSTURAL_INSTABILITY);
        SymptomPatientClass p5s3 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.SPEECH_PROBLEM);
        SymptomPatientClass p5s4 = new SymptomPatientClass( SymptomType.NON_MOTOR_SYMPTOM, Symptoms.ANXIOUS);
        s5.add(p5s1);
        s5.add(p5s3);
        s5.add(p5s4);
        p5.setSymptoms(s5);



        Patient p6 = new Patient(6, "David Rosarío", 55);
        Treatment t6 =  Treatment.DOPAMINE_AGONISTS;
        p6.setCurrent_treatment(t6);
        List<Previous_disease> previousDiseaseList2 = new ArrayList<>();
        Previous_disease p6d1 = Previous_disease.DIABETES;
        previousDiseaseList2.add(p6d1);
        p6.setPrevious_diseases(previousDiseaseList2);
        List<SymptomPatientClass> s6 = new ArrayList<>();
        SymptomPatientClass p6s1 = new SymptomPatientClass(SymptomType.MOTOR_COMPLICATION, Symptoms.BRADYKINESIA);
        SymptomPatientClass p6s2 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        s6.add(p6s1);
        s6.add(p6s2);
        p6.setSymptoms(s6);


        Patient p7 = new Patient(7, "Cayetana Salas", 70, true);
        Treatment t7 = Treatment.LEVODOPA;
        p7.setCurrent_treatment(t7);
        List<SymptomPatientClass> s7 = new ArrayList<>();
        SymptomPatientClass p7s1 = new SymptomPatientClass( SymptomType.MOTOR_COMPLICATION, Symptoms.RIGIDITY_CAUSING_MOVEMENT_LOSS);
        s7.add(p7s1);
        p7.setSymptoms(s7);

        Patient p8 = new Patient(8, "David Novo", 65);
        Treatment t8 = Treatment.NO_TREATMENT;
        p8.setCurrent_treatment(t8);
        List<SymptomPatientClass> s8 = new ArrayList<>();
        SymptomPatientClass p8s1 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.BRADYKINESIA);
        SymptomPatientClass p8s2 = new SymptomPatientClass(SymptomType.MOTOR_SYMPTOM, Symptoms.HOBBIES_AND_DAILY_TASKS_PROBLEMS);
        SymptomPatientClass p8s3 = new SymptomPatientClass( SymptomType.MOTOR_SYMPTOM, Symptoms.TREMOR);
        SymptomPatientClass p8s4 = new SymptomPatientClass(SymptomType.MOTOR_COMPLICATION, Symptoms.POSTURAL_INSTABILITY);
        s8.add(p8s1);
        s8.add(p8s2);
        s8.add(p8s3);
        s8.add(p8s4);
        p8.setSymptoms(s8);
        List<Previous_disease> previousDiseaseList8 = new ArrayList<>();
        Previous_disease p8d1 = Previous_disease.HISTORY_OF_GLAUCOMA;
        previousDiseaseList8.add(p8d1);
        p8.setPrevious_diseases(previousDiseaseList8);

        Patient p9 = new Patient(9, "David Novo", 65);
        Treatment t9 = Treatment.DOPAMINE_AGONISTS;
        p9.setCurrent_treatment(t9);
        p9.setWorsen(true);
        p9.setSymptoms(s8);
        p9.setPrevious_diseases(previousDiseaseList8);


        if (instance == null) {

            instance = new PatientService();
            instance.patients.put(1,p1);
            instance.patients.put(2,p2);
            instance.patients.put(3,p3);
            instance.patients.put(4,p4);
            instance.patients.put(5,p5);
            instance.patients.put(6,p6);
            instance.patients.put(7,p7);
            instance.patients.put(8,p8);
            instance.patients.put(9,p9);
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