package com.cnam.project.projectcnam.bdd.DTO;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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

    @NotBlank
    private String name;

    @NotBlank
    private Integer nbPerson;

    @NotBlank
    private Integer idUser;

    public RecipeDTO(Long idRecipe, @NotBlank String idHashRecipe, @NotBlank String name, @NotBlank Integer nbPerson, @NotBlank Integer idUser) {
        this.idRecipe = idRecipe;
        this.idHashRecipe = idHashRecipe;
        this.name = name;
        this.nbPerson = nbPerson;
        this.idUser = idUser;
    }

    public Long getIdRecipe() {
        return idRecipe;
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
}
