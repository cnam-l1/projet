package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.dao.model.IngredientDao;
import com.cnam.project.projectcnam.dao.model.UserDao;
import com.cnam.project.projectcnam.dao.repository.IngredientRepository;
import com.cnam.project.projectcnam.service.model.Credentials;
import io.swagger.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;


//    public String ingredientCreate(Credentials credentials, UserDao user, Ingredient ingredient) {
//
//        IngredientDao ingredientDao = new IngredientDao();
//        ingredientDao.setId_hash("unIdQuiSeraGenere");
//        ingredientDao.setNom(ingredient.getName());
//
//        return ingredientRepository.save(ingredientDao).getId().toString();
//    }
//
//    public List<IngredientDao> ingredientFind(Credentials credentials){
//
//        return ingredientRepository.findAll();
//    }
}
