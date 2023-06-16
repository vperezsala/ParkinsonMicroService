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

        Compatible compatible = new Compatible(id);
        DiseaseStage diseaseStage = new DiseaseStage(id,Stage.STAGE_0);


        try {
            KieServices ks1 = KieServices.Factory.get();
            //GET O NEW?
            KieContainer kContainer1 = ks1.newKieClasspathContainer();
            //Get the session named kseesion-rule that we defined in kmodule.xml above.
            //Also by default the session returned is always stateful.
            KieSession kieSession1 = kContainer1.newKieSession("patients_session");

            kieSession1.insert(patient);

            for(SymptomPatientClass sp : patient.getSymptoms()) {
                kieSession1.insert(new Symptom(id, sp.getType(), sp.getSymptomName()));
            }
            if(patient.getPrevious_diseases() == null){
                kieSession1.insert(new Disease(id));
            } else{
                for(Previous_disease pd : patient.getPrevious_diseases()) {
                    kieSession1.insert(new Disease(id, pd));
                }
            }

            Prescription p = new Prescription(id, patient.getCurrent_treatment());
            kieSession1.insert(p);
            kieSession1.insert(diseaseStage);
            kieSession1.insert(compatible);

            kieSession1.fireAllRules();

            patient.setCurrent_treatment(p.getTreatment());
            PatientService.getInstance().updatePatient(patient, id);
            kieSession1.dispose();



            //System.out.println(prescription);

        } catch (Throwable t) {
            System.out.println("Exception ---> DROOLS");
            t.printStackTrace();
        }

        return ok(ApplicationUtil.createResponse(Json.toJson(patient), true));

    }

}