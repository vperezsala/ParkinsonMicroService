package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class PrescriptionService {
    private static PrescriptionService instance;


    private Map<Integer, Prescription> prescriptions = new HashMap<>(){};



    public static PrescriptionService getInstance() {
        if (instance == null) {
            Prescription current1 = new Prescription(1,Treatment.NO_TREATMENT);
            Prescription current2 = new Prescription(2,Treatment.NO_TREATMENT);
            Prescription current3 = new Prescription(3, Treatment.MAO_B_INHIBITORS);
            Prescription current4 = new Prescription(4, Treatment.LEVODOPA);
            Prescription current5 = new Prescription(5, Treatment.DOPAMINE_AGONISTS);
            Prescription current6 = new Prescription(6, Treatment.DOPAMINE_AGONISTS);
            Prescription current7 = new Prescription(7, Treatment.LEVODOPA);
            instance = new PrescriptionService();
            instance.prescriptions.put(1,current1);
            instance.prescriptions.put(2,current2);
            instance.prescriptions.put(3,current3);
            instance.prescriptions.put(4,current4);
            instance.prescriptions.put(5,current5);
            instance.prescriptions.put(6,current6);
            instance.prescriptions.put(7,current7);
        }
        return instance;
    }

    public Prescription addPrescription(Prescription prescription) {
        int id = prescriptions.size()+1;
        prescription.setPatient(id);
        prescriptions.put(id, prescription);
        return prescription;
    }

    public Prescription getPrescription(int id) {
        return prescriptions.get(id);
    }

    public Set<Prescription> getAllPrescriptions() {
        return new HashSet<>(prescriptions.values());
    }

    public Prescription updatePrescription(Prescription prescription) {
        int id = prescription.getPatient();
        if (prescriptions.containsKey(id)) {
            prescriptions.put(id, prescription);
            return prescription;
        }
        return null;
    }

    public boolean deletePrescription(int id) {
        return prescriptions.remove(id) != null;
    }

}