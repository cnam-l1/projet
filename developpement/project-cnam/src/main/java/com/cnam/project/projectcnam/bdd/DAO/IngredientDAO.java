package com.cnam.project.projectcnam.bdd.DAO;

import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.bdd.exception.DAOException;
import com.cnam.project.projectcnam.bdd.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class IngredientDAO {

    @Autowired
    IngredientRepository ingredientRepository;

    public IngredientDTO save(IngredientDTO ingredientDTO) {

        try {

            return ingredientRepository.save(ingredientDTO);

        } catch (Exception e) {

            throw new DAOException("Impossible to save ingredient.");
        }
    }

    public List<IngredientDTO> findAll(UserDTO userDTO) {

        List<IngredientDTO> ingredientDTOList = new ArrayList<>();

        ingredientDTOList.addAll(ingredientRepository.findByIngredientsUser_idUser(userDTO.getIdUser()));
        ingredientDTOList.addAll(ingredientRepository.findByIngredientsUser_idUser(0L));

        if (ingredientDTOList.size() == 0) {

            throw new NotFoundException("Ingredient not found.");
        }

        return ingredientDTOList;
    }

    public IngredientDTO findByIdHashIngredient(String ingredientIdHash) {

        IngredientDTO ingredientDTO = ingredientRepository.findByIdHashIngredient(ingredientIdHash);

        if (ingredientDTO == null) {

            throw new NotFoundException("Ingredient not found.");

        }

        return ingredientDTO;
    }

    public void deleteByIdHashIngredient(String ingredientIdHash) {

        ingredientRepository.deleteByIdHashIngredient(ingredientIdHash);
    }
}
