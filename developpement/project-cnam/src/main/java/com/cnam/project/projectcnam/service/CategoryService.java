package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DTO.CategoryDTO;
import com.cnam.project.projectcnam.bdd.repository.CategoryRepository;
import io.swagger.model.Category;
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
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryRepository categoryRepository;

    public Integer getIdCategoryByName(Category category) {

        logger.debug("[getIdCategoryByName] is called. category : {}", category.toString());

        List<CategoryDTO> categoryDTOList = categoryRepository.findAll();

        for (CategoryDTO categoryDTO : categoryDTOList) {

            if (categoryDTO.getName().equals(category.toString())) {

                logger.debug("[getIdCategoryByName] category is find. category : {}", categoryDTO.getName());

                return categoryDTO.getIdCategory().intValue();
            }
        }

        throw new NotFoundException("Category is not found.");
    }

    public String getCategoryNameById(Integer idCategory) {

        logger.debug("[getCategoryNameById] is called. idCategory : {}", idCategory);

        List<CategoryDTO> categoryDTOList = categoryRepository.findAll();

        for (CategoryDTO categoryDTO : categoryDTOList) {

            if (categoryDTO.getIdCategory().intValue() == idCategory) {

                logger.debug("[getCategoryNameById] is find. idCategory : {}", idCategory);

                return categoryDTO.getName();
            }
        }

        throw new NotFoundException("Category is not found.");
    }
}
