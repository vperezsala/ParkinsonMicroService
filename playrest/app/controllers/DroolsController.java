package controllers;

import entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.ApplicationUtil;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import services.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DroolsController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result retrieveDiagnose(int id) {

        logger.debug("In DroolsController.retrieveDiagnoser(), generate diagnose for patient with id: {}", id);
        if (PatientService.getInstance().getPatient(id) == null) {
            return notFound(ApplicationUtil.createResponse("Patient with id:" + id + " not found", false));
        }

        Patient patient = PatientService.getInstance().getPatient(id);
        Set<Disease> disease = new HashSet<>();
        disease.addAll(DiseaseService.getInstance().getDiseases(id));
        System.out.println(disease);
        Set<Symptom> symptom = new HashSet<>();
        symptom.addAll(SymptomService.getInstance().getSymptoms(id));
        int i = symptom.size();
        System.out.println(i);
        Prescription prescription = PrescriptionService.getInstance().getPrescription(id);
        Compatible compatible = CompatibleService.getInstance().getCompatible(id);
        DiseaseStage diseaseStage = new DiseaseStage(id,Stage.STAGE_0);


        try {
            KieServices ks1 = KieServices.Factory.get();
            //GET O NEW?
            KieContainer kContainer1 = ks1.newKieClasspathContainer();
            //Get the session named kseesion-rule that we defined in kmodule.xml above.
            //Also by default the session returned is always stateful.
            KieSession kieSession1 = kContainer1.newKieSession("patients_session");

            kieSession1.insert(patient);
            kieSession1.insert(diseaseStage);
            kieSession1.insert(prescription);

            kieSession1.insert(compatible);
            System.out.println(compatible);

            for(Disease d:disease){
                kieSession1.insert(d);
                System.out.println(d);
            }
            for(Symptom s:symptom){
                kieSession1.insert(s);
                System.out.println(s);
            }

            kieSession1.fireAllRules();
            System.out.println("\n");
            System.out.println(prescription);
            //prescription = PrescriptionService.getInstance().updatePrescription(prescription);


        } catch (Throwable t) {
            System.out.println("Exception ---> DROOLS");
            t.printStackTrace();
        }

        return ok(ApplicationUtil.createResponse(Json.toJson(prescription), true));

    }

}