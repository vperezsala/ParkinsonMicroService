package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PrescriptionService;
import utils.ApplicationUtil;
import play.mvc.Http;

import java.util.Set;

public class PrescriptionController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In PrescriptionController.create(), input is: {}", json.toString());
        Prescription prescription = PrescriptionService.getInstance().addPrescription(Json.fromJson(json, Prescription.class));
        JsonNode jsonObject = Json.toJson(prescription);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result update(Http.Request request) {
        logger.debug("In PrescriptionController.update()");
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Prescription prescription = PrescriptionService.getInstance().updatePrescription(Json.fromJson(json, Prescription.class));
        logger.debug("In PrescriptionController.update(), prescription is: {}", prescription);
        if (prescription == null) {
            return notFound(ApplicationUtil.createResponse("Prescription not found", false));
        }

        JsonNode jsonObject = Json.toJson(prescription);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(int id) {
        logger.debug("In PrescriptionController.retrieve(), retrieve prescription with id: {}", id);
        if (PrescriptionService.getInstance().getPrescription(id) == null) {
            return notFound(ApplicationUtil.createResponse("Prescription with id:" + id + " not found", false));
        }
        JsonNode jsonObjects = Json.toJson(PrescriptionService.getInstance().getPrescription(id));
        logger.debug("In PrescriptionController.retrieve(), result is: {}", jsonObjects.toString());
        return ok(ApplicationUtil.createResponse(jsonObjects, true));
    }

    public Result listPrescriptions() {
        Set<Prescription> result = PrescriptionService.getInstance().getAllPrescriptions();
        logger.debug("In PrescriptionController.listPrescriptions(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }

    public Result delete(int id) {
        logger.debug("In PrescriptionController.retrieve(), delete prescription with id: {}", id);
        if (!PrescriptionService.getInstance().deletePrescription(id)) {
            return notFound(ApplicationUtil.createResponse("Prescription with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Prescription with id:" + id + " deleted", true));
    }
}