package com.cnam.project.projectcnam.bdd.DAO;

import com.cnam.project.projectcnam.bdd.DTO.RecipeDTO;
import com.cnam.project.projectcnam.bdd.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class RecipeDAO {

    private Logger logger = LoggerFactory.getLogger(RecipeDAO.class);

    @Autowired
    RecipeRepository recipeRepository;

    public List<RecipeDTO> findAll(Integer idUser) {

        return recipeRepository.findByIdUser(idUser);

    }

    public RecipeDTO save(RecipeDTO recipeDTO) {

        return recipeRepository.save(recipeDTO);
    }
}
