package com.cnam.project.projectcnam.bdd.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Embeddable
public class IngredientRecipeIdDTO implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private IngredientDTO ingredientDTO;

    @ManyToOne(cascade = CascadeType.ALL)
    private RecipeDTO recipe;

    public IngredientRecipeIdDTO() {
    }

    public IngredientRecipeIdDTO(IngredientDTO ingredientDTO, RecipeDTO recipe) {
        this.ingredientDTO = ingredientDTO;
        this.recipe = recipe;
    }

    public IngredientDTO getIngredientDTO() {
        return ingredientDTO;
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.ingredientDTO = ingredientDTO;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
