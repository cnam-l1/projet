package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.dao.model.IngredientDao;
import com.cnam.project.projectcnam.dao.repository.IngredientRepository;
import io.swagger.model.Category;
import io.swagger.model.Ingredient;
import io.swagger.model.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MeasureUnitService measureUnitService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Ingredient ingredientCreate(@Valid Ingredient ingredient) {

        checkArgument(ingredient != null, "Ingredient must not be null.");
        checkArgument(!ingredient.getIdIngredient().isEmpty(), "Ingredient identifier is mandatory.");
        checkArgument(!ingredient.getName().isEmpty(), "Ingredient name is mandatory.");
        checkArgument(ingredient.getCategory() != null, "Category is mandatory.");
        checkArgument(ingredient.getUnitOfMeasure() != null, "Unit of measure is mandatory.");

        IngredientDao ingredientDao = this.convertIngredientClientInIngredientDao(ingredient);

        IngredientDao ingredientDaoCreated = ingredientRepository.save(ingredientDao);

        Ingredient newIngredient = this.convertIngredientDaoInIngredientClient(ingredientDaoCreated);

        return newIngredient;
    }

    public IngredientDao convertIngredientClientInIngredientDao(Ingredient ingredient) {

        IngredientDao ingredientDao = new IngredientDao();

        ingredientDao.setIdCategory(categoryService.getIdCategoryByName(ingredient.getCategory()));
        ingredientDao.setIdHash(UUID.randomUUID().toString());
        ingredientDao.setName(ingredient.getName());
        ingredientDao.setIdMesureUnit(measureUnitService.getIdMesureUnitByName(ingredient.getUnitOfMeasure()));

        return ingredientDao;
    }

    public Ingredient convertIngredientDaoInIngredientClient(IngredientDao ingredientDao) {

        Ingredient ingredient = new Ingredient();

        ingredient.setCategory(Category.fromValue(categoryService.getCategoryNameById(ingredientDao.getIdCategory())));
        ingredient.setIdIngredient(ingredientDao.getIdHash());
        ingredient.setName(ingredientDao.getName());
        ingredient.setUnitOfMeasure(UnitOfMeasure.fromValue(measureUnitService.getMeasureUnitNameById(ingredientDao.getIdMesureUnit())));

        return ingredient;
    }


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
