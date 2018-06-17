package com.cnam.project.projectcnam.dao.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "ingredient")
@EntityListeners(AuditingEntityListener.class)
public class IngredientDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long idIngredient;

    @NotBlank
    @Column(name = "id_hash")
    private String idHash;

    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "id_mesure_unit")
    private int idMesureUnit;

    @NotBlank
    @Column(name = "id_category")
    private int idCategory;


    public IngredientDao() {
    }

    public IngredientDao(Long idIngredient, @NotBlank String idHash, @NotBlank String name, @NotBlank int idMesureUnit, @NotBlank int idCategory) {
        this.idIngredient = idIngredient;
        this.idHash = idHash;
        this.name = name;
        this.idMesureUnit = idMesureUnit;
        this.idCategory = idCategory;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getIdHash() {
        return idHash;
    }

    public void setIdHash(String idHash) {
        this.idHash = idHash;
    }

    public int getIdMesureUnit() {
        return idMesureUnit;
    }

    public void setIdMesureUnit(int idMesureUnit) {
        this.idMesureUnit = idMesureUnit;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
