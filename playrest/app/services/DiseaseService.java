package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import play.libs.Json;


public class DiseaseService {
    private static DiseaseService instance;
    private Map<Integer, Disease> diseases = new HashMap<>(){};


    public static DiseaseService getInstance() {

        if (instance == null) {
            Disease p1d1 = new Disease(1);
            Disease p2d1 = new Disease(2);
            Disease p3d1 = new Disease(3);
            Disease p4d1 = new Disease(4);
            Disease p5d1 = new Disease(5);
            Disease p6d1 = new Disease(6, Previous_disease.DIABETES);
            Disease p7d1 = new Disease(7);
            instance = new DiseaseService();
            instance.diseases.put(1,p1d1);
            instance.diseases.put(2,p2d1);
            instance.diseases.put(3,p3d1);
            instance.diseases.put(4,p4d1);
            instance.diseases.put(5,p5d1);
            instance.diseases.put(6,p6d1);
            instance.diseases.put(7,p7d1);
        }
        return instance;
    }

    public Disease addDisease(Disease disease) {
        int diseaseID = diseases.size() + 1;
        disease.setDiseaseID(disease.getDiseaseID());
        diseases.put(diseaseID, disease);
        return disease;
    }

    public Disease getDisease(int diseaseID) {
        return diseases.get(diseaseID);
    }
    public Set<Disease> getDiseases(int id){
        Set<Disease> d = new HashSet<>();
        Collection<Disease> d1 = diseases.values();
        for(Disease disease: d1){
            if(id == disease.getPatient()) {
                int diseaseID = disease.getDiseaseID();
                d.add(diseases.get(diseaseID));
            }
        }

        return d;
    }


    public Set<Disease> getAllDiseases() {
        return new HashSet<>(diseases.values());
    }

    public Disease updateDisease(Disease disease) {
        int diseaseID = disease.getDiseaseID();
        if (diseases.containsKey(diseaseID)) {
            diseases.put(diseaseID, disease);
            return disease;
        }
        return null;
    }

    public boolean deleteDisease(int diseaseID) {
        return diseases.remove(diseaseID) != null;
    }

}