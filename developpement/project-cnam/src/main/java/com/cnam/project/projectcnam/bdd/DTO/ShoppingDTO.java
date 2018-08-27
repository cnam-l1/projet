package com.cnam.project.projectcnam.bdd.DTO;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "shopping")
@EntityListeners(AuditingEntityListener.class)
public class ShoppingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping")
    private Long idShopping;

    @NotBlank
    @Column(name = "id_hash_shopping")
    private String idHashShopping;

    @OneToMany(mappedBy = "pk.shopping",
            cascade = CascadeType.ALL)
    private List<IngredientShoppingDTO> ingredientShoppingDTOList;

    @Column(name = "id_user")
    Integer idUser;

    LocalDate date;

    public ShoppingDTO() {
    }

    public ShoppingDTO(Long idShopping, @NotBlank String idHashShopping, @NotBlank Integer idUser, LocalDate date) {
        this.idShopping = idShopping;
        this.idHashShopping = idHashShopping;
        this.idUser = idUser;
        this.date = date;
    }

    public Long getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(Long idShopping) {
        this.idShopping = idShopping;
    }

    public String getIdHashShopping() {
        return idHashShopping;
    }

    public void setIdHashShopping(String idHashShopping) {
        this.idHashShopping = idHashShopping;
    }

    public List<IngredientShoppingDTO> getIngredientShoppingDTOList() {
        return ingredientShoppingDTOList;
    }

    public void setIngredientShoppingDTOList(List<IngredientShoppingDTO> ingredientShoppingDTOList) {
        this.ingredientShoppingDTOList = ingredientShoppingDTOList;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
