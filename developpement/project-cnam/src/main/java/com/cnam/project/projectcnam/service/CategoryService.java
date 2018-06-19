package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.dao.model.CategoryDao;
import com.cnam.project.projectcnam.dao.repository.CategoryRepository;
import com.cnam.project.projectcnam.exception.model.BadRequestException;
import com.cnam.project.projectcnam.exception.model.InternalServerError;
import com.cnam.project.projectcnam.exception.model.NotFoundException;
import io.swagger.model.Category;
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

    @Autowired
    CategoryRepository categoryRepository;

    public Integer getIdCategoryByName(Category category) {

        List<CategoryDao> categoryDaoList = categoryRepository.findAll();

        for (CategoryDao categoryDao : categoryDaoList) {

            if (categoryDao.getName().equals(category.name())) {

                return categoryDao.getIdCategory().intValue();
            }
        }

        throw new NotFoundException("Category is not found.");
    }

    public String getCategoryNameById(Integer idCategory) {

        List<CategoryDao> categoryDaoList = categoryRepository.findAll();

        for (CategoryDao categoryDao : categoryDaoList) {

            if (categoryDao.getIdCategory().equals(idCategory)) {

                return categoryDao.getName();
            }
        }

        throw new InternalServerError("An error occured.");
    }
}
