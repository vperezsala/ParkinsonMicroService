package services;

import entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import play.libs.Json;

public class CompatibleService {
    private static CompatibleService instance;
    private Map<Integer, Compatible> compatibles = new HashMap<>(){};


    public static CompatibleService getInstance() {
        if (instance == null) {
            Compatible compatible1 = new Compatible(1);
            Compatible compatible2 = new Compatible(2);
            Compatible compatible3 = new Compatible(3);
            Compatible compatible4 = new Compatible(4);
            Compatible compatible5 = new Compatible(5);
            Compatible compatible6 = new Compatible(6);
            Compatible compatible7 = new Compatible(7);
            instance = new CompatibleService();
            instance.compatibles.put(1,compatible1);
            instance.compatibles.put(2,compatible2);
            instance.compatibles.put(3,compatible3);
            instance.compatibles.put(4,compatible4);
            instance.compatibles.put(5,compatible5);
            instance.compatibles.put(6,compatible6);
            instance.compatibles.put(7,compatible7);
        }
        return instance;
    }

    public Compatible addCompatible(Compatible compatible) {
        int id = compatibles.size() + 1;
        compatible.setPatient(id);
        compatibles.put(id, compatible);
        return compatible;
    }

    public Compatible getCompatible(int id) {
        return compatibles.get(id);
    }

    public Set<Compatible> getAllCompatibles() {
        return new HashSet<>(compatibles.values());
    }

    public Compatible updateCompatible(Compatible compatible) {
        int id = compatible.getPatient();
        if (compatibles.containsKey(id)) {
            compatibles.put(id, compatible);
            return compatible;
        }
        return null;
    }

    public boolean deleteCompatible(int id) {
        return compatibles.remove(id) != null;
    }

}