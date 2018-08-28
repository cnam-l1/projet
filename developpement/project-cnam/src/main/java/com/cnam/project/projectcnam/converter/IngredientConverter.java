package com.cnam.project.projectcnam.converter;

import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import com.cnam.project.projectcnam.service.CategoryService;
import com.cnam.project.projectcnam.service.MeasureUnitService;
import io.swagger.model.Category;
import io.swagger.model.Ingredient;
import io.swagger.model.MeasureUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Component
public class IngredientConverter {

    private Logger logger = LoggerFactory.getLogger(IngredientConverter.class);

    @Autowired
    CategoryService categoryService;

    @Autowired
    MeasureUnitService measureUnitService;

    /**
     * @param ingredient
     * @return
     */
    public IngredientDTO convertIngredientClientInIngredientDTO(Ingredient ingredient) {

        logger.debug("[convertIngredientClientInIngredientDTO] is called. ingredient.id : {}", ingredient.getIdIngredient());

        Integer idMeasureUnit = measureUnitService.getIdMesureUnitByName(ingredient.getMeasureUnit());

        Integer idCategory = categoryService.getIdCategoryByName(ingredient.getCategory());

        IngredientDTO ingredientDTO = new IngredientDTO();

        ingredientDTO.setIdHashIngredient(ingredient.getIdIngredient());
        ingredientDTO.setIdCategory(idCategory);
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setIdMesureUnit(idMeasureUnit);

        return ingredientDTO;
    }

    /**
     * @param ingredientDTO
     * @return
     */
    public Ingredient convertIngredientDTOInIngredientClient(IngredientDTO ingredientDTO) {

        logger.debug("[convertIngredientDTOInIngredientClient] is called. ingredientDTO.idHash : {}", ingredientDTO.getIdHashIngredient());

        Ingredient ingredient = new Ingredient();

        ingredient.setCategory(Category.fromValue(categoryService.getCategoryNameById(ingredientDTO.getIdCategory())));
        ingredient.setIdIngredient(ingredientDTO.getIdHashIngredient());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setMeasureUnit(MeasureUnit.fromValue(measureUnitService.getMeasureUnitNameById(ingredientDTO.getIdMesureUnit())));

        return ingredient;
    }
}
