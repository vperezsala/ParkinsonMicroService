package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CompatibleService;
import utils.ApplicationUtil;
import play.mvc.Http;

import java.util.Set;

public class CompatibleController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In CompatibleController.create(), input is: {}", json.toString());
        Compatible compatible = CompatibleService.getInstance().addCompatible(Json.fromJson(json, Compatible.class));
        JsonNode jsonObject = Json.toJson(compatible);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result update(Http.Request request) {
        logger.debug("In CompatibleController.update()");
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Compatible compatible = CompatibleService.getInstance().updateCompatible(Json.fromJson(json, Compatible.class));
        logger.debug("In CompatibleController.update(), compatible is: {}", compatible);
        if (compatible == null) {
            return notFound(ApplicationUtil.createResponse("Compatible not found", false));
        }

        JsonNode jsonObject = Json.toJson(compatible);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(int id) {
        logger.debug("In CompatibleController.retrieve(), retrieve compatible with id: {}", id);
        if (CompatibleService.getInstance().getCompatible(id) == null) {
            return notFound(ApplicationUtil.createResponse("Compatible with id:" + id + " not found", false));
        }
        JsonNode jsonObjects = Json.toJson(CompatibleService.getInstance().getCompatible(id));
        logger.debug("In CompatibleController.retrieve(), result is: {}", jsonObjects.toString());
        return ok(ApplicationUtil.createResponse(jsonObjects, true));
    }

    public Result listCompatible() {
        Set<Compatible> result = CompatibleService.getInstance().getAllCompatibles();
        logger.debug("In CompatibleController.listCompatible(), result is: {}", result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }

    public Result delete(int id) {
        logger.debug("In CompatibleController.retrieve(), delete compatible with id: {}", id);
        if (!CompatibleService.getInstance().deleteCompatible(id)) {
            return notFound(ApplicationUtil.createResponse("Compatible with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Compatible with id:" + id + " deleted", true));
    }
}