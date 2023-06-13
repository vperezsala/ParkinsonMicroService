package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Symptom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.SymptomService;
import utils.ApplicationUtil;
import play.mvc.Http;

import java.util.Set;
public class SymptomController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In SymptomController.create(), input is: {}", json.toString());
        Symptom symptom = SymptomService.getInstance().addSymptom(Json.fromJson(json, Symptom.class));
        JsonNode jsonObject = Json.toJson(symptom);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result update(Http.Request request) {
        logger.debug("In SymptomController.update()");
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Symptom symptom = SymptomService.getInstance().updateSymptom(Json.fromJson(json, Symptom.class));
        logger.debug("In SymptomController.update(), symptom is: {}", symptom);
        if (symptom == null) {
            return notFound(ApplicationUtil.createResponse("Symptom not found", false));
        }

        JsonNode jsonObject = Json.toJson(symptom);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(int id) {
        logger.debug("In SymptomController.retrieve(), retrieve symptom with id: {}", id);
        if (SymptomService.getInstance().getSymptom(id) == null) {
            return notFound(ApplicationUtil.createResponse("Symptom with id:" + id + " not found", false));
        }
        JsonNode jsonObjects = Json.toJson(SymptomService.getInstance().getSymptom(id));
        logger.debug("In SymptomController.retrieve(), result is: {}", jsonObjects.toString());
        return ok(ApplicationUtil.createResponse(jsonObjects, true));
    }

    public Result listSymptoms() {
        Set<Symptom> result = SymptomService.getInstance().getAllSymptoms();
        logger.debug("In SymptomController.listSymptoms(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }

    public Result delete(int id) {
        logger.debug("In SymptomController.retrieve(), delete symptom with id: {}", id);
        if (!SymptomService.getInstance().deleteSymptom(id)) {
            return notFound(ApplicationUtil.createResponse("Symptom with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Symptom with id:" + id + " deleted", true));
    }
}