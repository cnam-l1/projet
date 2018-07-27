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
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @NotBlank
    @Column(name = "id_hash_user")
    private String idHashUser;

    @ManyToMany(mappedBy = "ingredientsUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<IngredientDTO> ingredientsUser = new ArrayList<>();

    @NotBlank
    private String login;

    @NotBlank
    private String password;


    public UserDTO() {
    }

    public UserDTO(Long idUser, @NotBlank String idHashUser, List<IngredientDTO> ingredientsUser, @NotBlank String login, @NotBlank String password) {
        this.idUser = idUser;
        this.idHashUser = idHashUser;
        this.ingredientsUser = ingredientsUser;
        this.login = login;
        this.password = password;
    }

    public List<IngredientDTO> getIngredientsUser() {
        return ingredientsUser;
    }

    public void setIngredientsUser(List<IngredientDTO> ingredientsUser) {
        this.ingredientsUser = ingredientsUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getIdHashUser() {
        return idHashUser;
    }

    public void setIdHashUser(String idHashUser) {
        this.idHashUser = idHashUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
