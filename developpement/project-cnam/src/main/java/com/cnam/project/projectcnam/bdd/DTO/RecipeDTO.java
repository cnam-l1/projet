package com.cnam.project.projectcnam.bdd.DTO;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "recipe")
@EntityListeners(AuditingEntityListener.class)
public class RecipeDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long idRecipe;

    @NotBlank
    @Column(name = "id_hash_recipe")
    private String idHashRecipe;

    @OneToMany(mappedBy = "pk.recipe",
            cascade = CascadeType.ALL)
    private List<IngredientRecipeDTO> ingredientRecipeDTOList;

    @NotBlank
    private String name;

    private Integer nbPerson;

    private Integer idUser;

    public RecipeDTO() {
    }

    public RecipeDTO(Long idRecipe, @NotBlank String idHashRecipe, List<IngredientRecipeDTO> ingredientRecipeDTOList, @NotBlank String name, Integer nbPerson, Integer idUser) {
        this.idRecipe = idRecipe;
        this.idHashRecipe = idHashRecipe;
        this.ingredientRecipeDTOList = ingredientRecipeDTOList;
        this.name = name;
        this.nbPerson = nbPerson;
        this.idUser = idUser;
    }

    public Long getIdRecipe() {
        return idRecipe;
    }

    public List<IngredientRecipeDTO> getIngredientRecipeDTOList() {
        return ingredientRecipeDTOList;
    }

    public void setIngredientRecipeDTOList(List<IngredientRecipeDTO> ingredientRecipeDTOList) {
        this.ingredientRecipeDTOList = ingredientRecipeDTOList;
    }

    public void setIdRecipe(Long idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getIdHashRecipe() {
        return idHashRecipe;
    }

    public void setIdHashRecipe(String idHashRecipe) {
        this.idHashRecipe = idHashRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbPerson() {
        return nbPerson;
    }

    public void setNbPerson(Integer nbPerson) {
        this.nbPerson = nbPerson;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
