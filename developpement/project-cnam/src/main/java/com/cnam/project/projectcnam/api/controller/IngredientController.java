package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.service.AuthorizationService;
import com.cnam.project.projectcnam.service.IngredientService;
import com.cnam.project.projectcnam.service.model.Credentials;
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

import static com.google.common.base.Preconditions.checkArgument;

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
    AuthorizationService auth;

    public ResponseEntity<Ingredient> ingredientCreate(@Valid @RequestBody Ingredient ingredient) {

        logger.debug("[IngredientController] [ingredientCreate] is called. ingredient.name", ingredient.getName());

        Credentials credentials = auth.getAndValidCredentials();

        Ingredient newIngredient = ingredientService.ingredientCreate(ingredient);

        logger.debug("[IngredientController] [ingredientCreate] is created. newIngredient.id", newIngredient.getIdIngredient());

        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<Ingredient>> ingredientFind() {

//        Credentials credentials = authorizationService.getAndValidCredentials();
//
//        UserDao userDao = userService.getUser(credentials);
//
//        List<IngredientDao> ingredientList = ingredientService.ingredientFind(credentials);
//
//        return new ResponseEntity<>(ingredientList, HttpStatus.CREATED);

        return null;
    }

    @Override
    public ResponseEntity<Void> ingredientDelete(@PathVariable("ingredientId") String ingredientId) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientGet(@PathVariable("ingredientId") String ingredientId) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientPatch(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientUpdate(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        return null;
    }
}
