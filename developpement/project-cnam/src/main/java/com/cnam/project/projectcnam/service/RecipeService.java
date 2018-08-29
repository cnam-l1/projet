package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.api.controller.IngredientController;
import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DAO.IngredientDAO;
import com.cnam.project.projectcnam.bdd.DAO.RecipeDAO;
import com.cnam.project.projectcnam.bdd.DAO.UserDAO;
import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import com.cnam.project.projectcnam.bdd.DTO.IngredientRecipeDTO;
import com.cnam.project.projectcnam.bdd.DTO.RecipeDTO;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.converter.RecipeConverter;
import com.cnam.project.projectcnam.security.model.Credentials;
import io.swagger.model.Ingredient;
import io.swagger.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class RecipeService {

    Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    RecipeDAO recipeDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    IngredientDAO ingredientDAO;

    @Autowired
    RecipeConverter recipeConverter;

    public Recipe recipeCreate(Credentials credentials, @Valid Recipe recipe) {

        logger.debug("[recipeCreate] is called. recipe.name : {}", recipe.getName());

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        recipe.setIdRecipe(UUID.randomUUID().toString());
        RecipeDTO recipeDTO = recipeConverter.convertRecipeClientInRecipeDTO(recipe, userDTO.getIdUser());

        List<IngredientRecipeDTO> ingredientRecipeDTOList = new ArrayList<>();

        if (recipe.getIngredientList() != null) {

            for (Ingredient ingredient : recipe.getIngredientList()) {

                IngredientRecipeDTO ingredientRecipeDTO = new IngredientRecipeDTO();

                IngredientDTO ingredientDTO = ingredientDAO.findByIdHashIngredient(ingredient.getIdIngredient());

                ingredientRecipeDTO.setIngredientDTO(ingredientDTO);

                ingredientRecipeDTO.setQuantity(ingredient.getQuantity());

                ingredientRecipeDTO.setRecipe(recipeDTO);

                ingredientRecipeDTOList.add(ingredientRecipeDTO);

            }
        }

        recipeDTO.setIngredientRecipeDTOList(ingredientRecipeDTOList);

        Recipe newRecipe = recipeConverter.convertRecipeDTOInRecipeClient(recipeDAO.save(recipeDTO));

        return newRecipe;
    }

    public List<Recipe> recipeFind(Credentials credentials) {

        logger.debug("[recipeFind] is called.");

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<RecipeDTO> recipeDTOList = recipeDAO.findAll(userDTO.getIdUser().intValue());

        List<Recipe> recipeList = new ArrayList<>();

        for (RecipeDTO recipeDTO : recipeDTOList) {

            Recipe recipe = recipeConverter.convertRecipeDTOInRecipeClient(recipeDTO);

            recipeList.add(recipe);
        }

        return recipeList;
    }

    public Recipe getRecipe(Credentials credentials, String recipeId) {

        logger.debug("[getRecipe] is called. recipeId : {}", recipeId);

        Recipe recipe = null;

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<RecipeDTO> recipeDTOList = recipeDAO.findAll(userDTO.getIdUser().intValue());

        for (RecipeDTO recipeDTO : recipeDTOList) {

            if (recipeDTO.getIdHashRecipe().equals(recipeId)) {

                recipe = recipeConverter.convertRecipeDTOInRecipeClient(recipeDTO);
            }
        }

        if (recipe == null) {

            throw new NotFoundException("Recipe not found.");
        }

        return recipe;
    }
}
