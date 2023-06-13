package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Disease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.DiseaseService;
import utils.ApplicationUtil;
import play.mvc.Http;

import java.util.Set;

public class DiseaseController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In DiseaseController.create(), input is: {}", json.toString());
        Disease disease = DiseaseService.getInstance().addDisease(Json.fromJson(json, Disease.class));
        JsonNode jsonObject = Json.toJson(disease);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result update(Http.Request request) {
        logger.debug("In DiseaseController.update()");
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Disease disease = DiseaseService.getInstance().updateDisease(Json.fromJson(json, Disease.class));
        logger.debug("In DiseaseController.update(), disease is: {}", disease);
        if (disease == null) {
            return notFound(ApplicationUtil.createResponse("Disease not found", false));
        }

        JsonNode jsonObject = Json.toJson(disease);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(int id) {
        logger.debug("In DiseaseController.retrieve(), retrieve disease with id: {}", id);
        if (DiseaseService.getInstance().getDisease(id) == null) {
            return notFound(ApplicationUtil.createResponse("Disease with id:" + id + " not found", false));
        }
        JsonNode jsonObjects = Json.toJson(DiseaseService.getInstance().getDisease(id));
        logger.debug("In DiseaseController.retrieve(), result is: {}", jsonObjects.toString());
        return ok(ApplicationUtil.createResponse(jsonObjects, true));
    }

    public Result listDiseases() {
        Set<Disease> result = DiseaseService.getInstance().getAllDiseases();
        logger.debug("In DiseaseController.listDiseases(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }

    public Result delete(int id) {
        logger.debug("In DiseaseController.retrieve(), delete disease with id: {}", id);
        if (!DiseaseService.getInstance().deleteDisease(id)) {
            return notFound(ApplicationUtil.createResponse("Disease of patient with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Disease of patients with id:" + id + " deleted", true));
    }
}