package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.security.model.Credentials;
import com.cnam.project.projectcnam.security.requestValidator.RequestValidator;
import com.cnam.project.projectcnam.service.IngredientService;
import io.swagger.api.IngredientApi;
import io.swagger.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@RestController
public class IngredientController implements IngredientApi {

    Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    IngredientService ingredientService;

    @Autowired
    RequestValidator requestValidator;

    @Override
    public ResponseEntity<Ingredient> ingredientCreate(@Valid @RequestBody Ingredient ingredient) {

        logger.debug("[IngredientController] [ingredientCreate] is called. ingredient.name", ingredient.getName());

        requestValidator.validateRequest();

        Ingredient newIngredient = ingredientService.ingredientCreate(requestValidator.getCredentials(), ingredient);

        logger.debug("[IngredientController] [ingredientCreate] is created. newIngredient.id", newIngredient.getIdIngredient());

        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Ingredient>> ingredientFind() {

        logger.debug("[IngredientController] [ingredientFind] is called.");

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        List<Ingredient> ingredientList = ingredientService.ingredientFind(credentials);

        logger.debug("[IngredientController] [ingredientFind] ingredientList.size : {}", ingredientList.size());

        return new ResponseEntity<>(ingredientList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ingredient> ingredientGet(@PathVariable("ingredientId") String ingredientId) {

        logger.debug("[IngredientController] [ingredientCreate] is called. ingredientId : {}", ingredientId);

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        Ingredient ingredient = ingredientService.ingredientGet(credentials, ingredientId);

        logger.debug("[IngredientController] [ingredientCreate] ingredient.id : {}", ingredient.getIdIngredient());

        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> ingredientDelete(@PathVariable("ingredientId") String ingredientId) {

        logger.debug("[IngredientController] [ingredientDelete] is called. ingredientId : {} ", ingredientId);

        requestValidator.validateRequest();

        ingredientService.ingredientDelete(requestValidator.getCredentials(), ingredientId);

        logger.debug("[IngredientController] [ingredientDelete] ingredientId : {} is deleted", ingredientId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ingredient> ingredientUpdate(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        logger.debug("[IngredientController] [ingredientUpdate] is called. ingredientId : {}", ingredientId);

        requestValidator.validateRequest();

        Ingredient ingredientUpdated = ingredientService.ingredientUpdate(ingredientId, ingredient);

        return new ResponseEntity<Ingredient>(ingredientUpdated, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Ingredient> ingredientPatch(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        logger.debug("[IngredientController] [ingredientPatch] is called. ingredientId : {}", ingredientId);

        requestValidator.validateRequest();

        Ingredient ingredientPatched = ingredientService.ingredientPatch(ingredientId, ingredient);

        return new ResponseEntity<Ingredient>(ingredientPatched, HttpStatus.NOT_IMPLEMENTED);
    }
}
