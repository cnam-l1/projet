package com.cnam.project.projectcnam.converter;

import com.cnam.project.projectcnam.bdd.DTO.IngredientRecipeDTO;
import com.cnam.project.projectcnam.bdd.DTO.RecipeDTO;
import io.swagger.model.Ingredient;
import io.swagger.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Component
public class RecipeConverter {

    private Logger logger = LoggerFactory.getLogger(RecipeConverter.class);

    @Autowired
    IngredientConverter ingredientConverter;

    public RecipeDTO convertRecipeClientInRecipeDTO(Recipe recipe, Long idUser) {

        logger.debug("[convertRecipeClientInRecipeDTO] is called with recipe.name", recipe.getName());

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setIdHashRecipe(recipe.getIdRecipe());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setNbPerson(recipe.getNbPeople());
        recipeDTO.setIdUser(idUser.intValue());

        return recipeDTO;
    }

    public Recipe convertRecipeDTOInRecipeClient(RecipeDTO recipeDTO) {

        logger.debug("[convertRecipeDTOInRecipeClient] is called with recipeDTO.name", recipeDTO.getName());

        Recipe recipe = new Recipe();

        recipe.setIdRecipe(recipeDTO.getIdHashRecipe());
        recipe.setName(recipeDTO.getName());
        recipe.setNbPeople(recipeDTO.getNbPerson());

        List<Ingredient> ingredientList = new ArrayList<>();

        if (recipeDTO.getIngredientRecipeDTOList() != null) {

            for (IngredientRecipeDTO ingredientRecipeDTO : recipeDTO.getIngredientRecipeDTOList()) {

                Ingredient ingredient = ingredientConverter.convertIngredientDTOInIngredientClient(ingredientRecipeDTO.getIngredientDTO());
                ingredient.setQuantity(ingredientRecipeDTO.getQuantity());
                ingredientList.add(ingredient);

            }
        }

        recipe.setIngredientList(ingredientList);

        return recipe;
    }
}
