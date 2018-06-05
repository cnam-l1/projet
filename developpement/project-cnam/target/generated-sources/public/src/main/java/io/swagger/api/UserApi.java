/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.User;
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

@Api(value = "User", description = "the User API")
public interface UserApi {

    Logger log = LoggerFactory.getLogger(UserApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "create a user", nickname = "userCreate", notes = "This endpoint allows to create a user.", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Success", response = User.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<User> userCreate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Delete a user.", nickname = "userDelete", notes = "This endpoint allows to delete a user.", tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Success"),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> userDelete(@ApiParam(value = "User identifier.",required=true) @PathVariable("userId") String userId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "find a user", nickname = "userFind", notes = "This endpoint allows to get a list of users.", response = User.class, responseContainer = "List", tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<User>> userFind() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"}, {  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "get a user", nickname = "userGet", notes = "This endpoint allows to get a user.", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<User> userGet(@ApiParam(value = "User identifier.",required=true) @PathVariable("userId") String userId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Update partially a user", nickname = "userPatch", notes = "This endpoint allows to partially update a user.", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    default ResponseEntity<User> userPatch(@ApiParam(value = "User identifier.",required=true) @PathVariable("userId") String userId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Update a user.", nickname = "userUpdate", notes = "This endpoint allows to update a user.", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class),
        @ApiResponse(code = 500, message = "Internal Server Error  List of supported error codes: - 1: Internal error", response = Error.class) })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PUT)
    default ResponseEntity<User> userUpdate(@ApiParam(value = "User identifier.",required=true) @PathVariable("userId") String userId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json;charset=utf-8")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"idUser\" : \"idUser\",  \"firstname\" : \"firstname\",  \"name\" : \"name\",  \"email\" : \"email\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json;charset=utf-8", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
