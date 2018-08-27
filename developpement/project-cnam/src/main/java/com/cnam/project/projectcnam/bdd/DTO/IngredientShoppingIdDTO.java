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
public class IngredientShoppingIdDTO implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private IngredientDTO ingredientDTO;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShoppingDTO shopping;

    public IngredientShoppingIdDTO() {
    }

    public IngredientShoppingIdDTO(IngredientDTO ingredientDTO, ShoppingDTO shoppingDTO) {
        this.ingredientDTO = ingredientDTO;
        this.shopping = shoppingDTO;
    }

    public IngredientDTO getIngredientDTO() {
        return ingredientDTO;
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.ingredientDTO = ingredientDTO;
    }

    public ShoppingDTO getShopping() {
        return shopping;
    }

    public void setShopping(ShoppingDTO shopping) {
        this.shopping = shopping;
    }
}
