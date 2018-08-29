package com.cnam.project.projectcnam.bdd.repository;

import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Repository
public interface IngredientRepository extends JpaRepository<IngredientDTO, Long> {

    public IngredientDTO findByIdHashIngredient(String idHashIngredient);

    @Transactional
    public void deleteByIdHashIngredient(String idHashIngredient);

    public List<IngredientDTO> findByIngredientsUser_idUser(Long idUser);
}
