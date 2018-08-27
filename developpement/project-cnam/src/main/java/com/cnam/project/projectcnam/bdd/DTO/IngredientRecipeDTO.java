package com.cnam.project.projectcnam.bdd.DTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "ingredient_recipe")
@AssociationOverrides({
        @AssociationOverride(name = "pk.ingredientDTO",
                joinColumns = @JoinColumn(name = "id_ingredient")),
        @AssociationOverride(name = "pk.recipe",
                joinColumns = @JoinColumn(name = "id_recipe"))})
public class IngredientRecipeDTO implements Serializable {

    @EmbeddedId
    private IngredientRecipeIdDTO pk = new IngredientRecipeIdDTO();

    private Integer quantity;

    public IngredientRecipeDTO() {
    }

    public IngredientRecipeDTO(IngredientRecipeIdDTO pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public IngredientRecipeIdDTO getPk() {
        return pk;
    }

    public void setPk(IngredientRecipeIdDTO pk) {
        this.pk = pk;
    }

    @Transient
    public IngredientDTO getIngredientDTO() {
        return getPk().getIngredientDTO();
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.pk.setIngredientDTO(ingredientDTO);
    }

    public RecipeDTO getRecipe() {
        return getPk().getRecipe();
    }

    public void setRecipe(RecipeDTO recipe) {
        this.pk.setRecipe(recipe);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
