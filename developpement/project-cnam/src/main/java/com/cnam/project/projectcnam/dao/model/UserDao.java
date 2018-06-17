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
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class UserDao implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long idUser;

    @NotBlank
    @Column(name="id_hash_user")
    private String idHashUser;

    @NotBlank
    private String login;

    @NotBlank
    private String password;


    public UserDao() {
    }

    public UserDao(Long idUser, @NotBlank String idHashUser, @NotBlank String login, @NotBlank String password) {
        this.idUser = idUser;
        this.idHashUser = idHashUser;
        this.login = login;
        this.password = password;
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
}
