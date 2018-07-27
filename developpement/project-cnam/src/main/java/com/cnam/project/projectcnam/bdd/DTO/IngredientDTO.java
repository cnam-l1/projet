package com.cnam.project.projectcnam.bdd.DTO;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "ingredient")
@EntityListeners(AuditingEntityListener.class)
public class IngredientDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long idIngredient;

    @NotBlank
    @Column(name = "id_hash_ingredient")
    private String idHashIngredient;

    @NotBlank
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ingredient_user",
            joinColumns = {@JoinColumn(name = "id_ingredient")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")})
    private List<UserDTO> ingredientsUser = new ArrayList<UserDTO>();

    @Column(name = "id_mesure_unit")
    private Integer idMesureUnit;

    @Column(name = "id_category")
    private Integer idCategory;


    public IngredientDTO() {
    }

    public IngredientDTO(Long idIngredient, @NotBlank String idHashIngredient, @NotBlank String name, List<UserDTO> users, Integer idMesureUnit, Integer idCategory) {
        this.idIngredient = idIngredient;
        this.idHashIngredient = idHashIngredient;
        this.name = name;
        this.ingredientsUser = users;
        this.idMesureUnit = idMesureUnit;
        this.idCategory = idCategory;
    }

    public List<UserDTO> getIngredientsUser() {
        return ingredientsUser;
    }

    public void setIngredientsUser(List<UserDTO> users) {
        this.ingredientsUser = users;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getIdHashIngredient() {
        return idHashIngredient;
    }

    public void setIdHashIngredient(String idHashIngredient) {
        this.idHashIngredient = idHashIngredient;
    }

    public Integer getIdMesureUnit() {
        return idMesureUnit;
    }

    public void setIdMesureUnit(Integer idMesureUnit) {
        this.idMesureUnit = idMesureUnit;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "IngredientDTO{" +
                "idIngredient=" + idIngredient +
                ", idHashIngredient='" + idHashIngredient + '\'' +
                ", name='" + name + '\'' +
                ", idMesureUnit=" + idMesureUnit +
                ", idCategory=" + idCategory +
                '}';
    }
}
