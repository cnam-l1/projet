package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.api.controller.IngredientController;
import com.cnam.project.projectcnam.security.model.Credentials;
import io.swagger.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RecipeService {

    Logger logger = LoggerFactory.getLogger(IngredientController.class);

    public Recipe recipeCreate(Credentials credentials, @Valid Recipe recipe) {

        logger.debug("[recipeCreate] is called. recipe.name : {}", recipe.getName());

        return null;
    }
}
