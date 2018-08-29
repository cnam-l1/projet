package com.cnam.project.projectcnam.bdd.DTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "ingredient_shopping")
@AssociationOverrides({
        @AssociationOverride(name = "pk.ingredientDTO",
                joinColumns = @JoinColumn(name = "id_ingredient")),
        @AssociationOverride(name = "pk.shopping",
                joinColumns = @JoinColumn(name = "id_shopping"))})
public class IngredientShoppingDTO implements Serializable {

    @EmbeddedId
    private IngredientShoppingIdDTO pk = new IngredientShoppingIdDTO();

    private Integer quantity;

    public IngredientShoppingDTO() {
    }

    public IngredientShoppingDTO(IngredientShoppingIdDTO pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public IngredientShoppingIdDTO getPk() {
        return pk;
    }

    public void setPk(IngredientShoppingIdDTO pk) {
        this.pk = pk;
    }

    @Transient
    public IngredientDTO getIngredientDTO() {
        return getPk().getIngredientDTO();
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.pk.setIngredientDTO(ingredientDTO);
    }

    public ShoppingDTO shoppingDTO() {
        return getPk().getShopping();
    }

    public void setShoppingDTO(ShoppingDTO shopping) {
        this.pk.setShopping(shopping);
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
