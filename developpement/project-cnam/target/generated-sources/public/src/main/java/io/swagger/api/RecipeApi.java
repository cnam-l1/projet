/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api(value = "Recipe", description = "the Recipe API")
public interface RecipeApi {

    Logger log = LoggerFactory.getLogger(RecipeApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Create a recipe", nickname = "recipeCreate", notes = "This endpoint allows to create a recipe.", response = Recipe.class, tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Success", response = Recipe.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<Recipe> recipeCreate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Recipe recipe) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"}", Recipe.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Delete a recipe.", nickname = "recipeDelete", notes = "This endpoint allows to delete a recipe.", tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Success"),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> recipeDelete(@ApiParam(value = "Recipe identifier.",required=true) @PathVariable("recipeId") String recipeId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Find a recipe", nickname = "recipeFind", notes = "This endpoint allows to get a list of recipe.", response = Recipe.class, responseContainer = "List", tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Recipe.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Recipe>> recipeFind() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"}, {  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Get a recipe.", nickname = "recipeGet", notes = "This endpoint allows to get a recipe.", response = Recipe.class, tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Recipe.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Recipe> recipeGet(@ApiParam(value = "Recipe identifier.",required=true) @PathVariable("recipeId") String recipeId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"}", Recipe.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Update partially an ingredient.", nickname = "recipePatch", notes = "This endpoint allows to partially update an ingredient.", response = Recipe.class, tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Recipe.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    default ResponseEntity<Recipe> recipePatch(@ApiParam(value = "Recipe identifier.",required=true) @PathVariable("recipeId") String recipeId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Recipe recipe) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"}", Recipe.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Update a recipe.", nickname = "recipeUpdate", notes = "This endpoint allows to update a recipe.", response = Recipe.class, tags={ "Recipe", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Recipe.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PUT)
    default ResponseEntity<Recipe> recipeUpdate(@ApiParam(value = "Recipe identifier.",required=true) @PathVariable("recipeId") String recipeId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Recipe recipe) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"name\" : \"name\",  \"nbPeople\" : \"nbPeople\",  \"idRecipe\" : \"idRecipe\"}", Recipe.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RecipeApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
