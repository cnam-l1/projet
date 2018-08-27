package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.security.model.Credentials;
import com.cnam.project.projectcnam.security.requestValidator.RequestValidator;
import com.cnam.project.projectcnam.service.RecipeService;
import io.swagger.api.RecipeApi;
import io.swagger.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class RecipeController implements RecipeApi {

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    RequestValidator requestValidator;

    @Autowired
    RecipeService recipeService;

    @Override
    public ResponseEntity<Recipe> recipeCreate(@Valid @RequestBody Recipe recipe) {

        checkArgument(!recipe.getName().isEmpty(), "Recipe name is mandatory.");

        logger.debug("[recipeCreate] is called. recipe.name", recipe.getName());

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        Recipe recipeCreated = recipeService.recipeCreate(credentials, recipe);

        logger.debug("[recipeCreate] is created. recipe.id", recipe.getIdRecipe());

        return new ResponseEntity<Recipe>(recipeCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Recipe>> recipeFind() {

        logger.debug("[recipeCreate] is called.");

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        List<Recipe> recipeList = recipeService.recipeFind(credentials);

        return new ResponseEntity<List<Recipe>>(recipeList, HttpStatus.OK);
    }
}
