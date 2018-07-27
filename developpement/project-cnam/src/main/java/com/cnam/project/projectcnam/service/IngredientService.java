package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.api.exception.BadRequestException;
import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DAO.IngredientDAO;
import com.cnam.project.projectcnam.bdd.DAO.UserDAO;
import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.converter.IngredientConverter;
import com.cnam.project.projectcnam.security.model.Credentials;
import io.swagger.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class IngredientService {

    private Logger logger = LoggerFactory.getLogger(IngredientService.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    IngredientDAO ingredientDAO;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MeasureUnitService measureUnitService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IngredientConverter ingredientConverter;

    /**
     * @param ingredient
     * @return
     */
    public Ingredient ingredientCreate(Credentials credentials, @Valid Ingredient ingredient) {

        checkArgument(!ingredient.getName().isEmpty(), "Ingredient name is mandatory");

        logger.debug("[ingredientCreate] is called. ingredient.name : {}", ingredient.getName());

        ingredient.setIdIngredient(UUID.randomUUID().toString());
        IngredientDTO ingredientDTO = ingredientConverter.convertIngredientClientInIngredientDTO(ingredient);

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<UserDTO> user = new ArrayList<>();
        user.add(userDTO);

        ingredientDTO.setIngredientsUser(user);

        IngredientDTO ingredientDTOCreated = ingredientDAO.save(ingredientDTO);

        logger.debug("[ingredientCreate] ingredient is created with id : {}", ingredientDTOCreated.getIdHashIngredient());

        return ingredientConverter.convertIngredientDTOInIngredientClient(ingredientDTOCreated);
    }

    /**
     * @return
     */
    public List<Ingredient> ingredientFind(Credentials credentials) {

        logger.debug("[ingredientFind] is called.");

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<IngredientDTO> ingredientDTOList = ingredientDAO.findAll(userDTO);

        List<Ingredient> ingredientList = new ArrayList<>();

        for (IngredientDTO ingredientDTO : ingredientDTOList) {

            ingredientList.add(ingredientConverter.convertIngredientDTOInIngredientClient(ingredientDTO));
        }

        logger.debug("[ingredientFind] return ingredientList with ingredientList.size : {}", ingredientList.size());

        return ingredientList;
    }

    /**
     * @param ingredientIdHash
     * @return
     */
    public Ingredient ingredientGet(Credentials credentials, String ingredientIdHash) {

        checkArgument(!ingredientIdHash.isEmpty(), "Ingredient identifier must not be empty.");

        logger.debug("[ingredientFind] is called. ingredientIdHash : {}", ingredientIdHash);

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<IngredientDTO> ingredientDTOList = ingredientDAO.findAll(userDTO);

        for (IngredientDTO ingredientDTO : ingredientDTOList) {

            if (ingredientDTO.getIdHashIngredient().equals(ingredientIdHash)) {

                logger.debug("[ingredientFind] return ingredient. ingredientIdHash : {}", ingredientIdHash);

                return ingredientConverter.convertIngredientDTOInIngredientClient(ingredientDTO);
            }
        }

        throw new NotFoundException("Ingredient not found.");
    }

    /**
     * @param credentials
     * @param ingredientIdHash
     */
    public void ingredientDelete(Credentials credentials, String ingredientIdHash) {

        checkArgument(!ingredientIdHash.isEmpty(), "Ingredient identifier must not be empty.");

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        IngredientDTO ingredientDTO = ingredientDAO.findByIdHashIngredient(ingredientIdHash);

        if (!ingredientDTO.getIngredientsUser().get(0).getIdUser().equals(userDTO.getIdUser())) {

            throw new BadRequestException("Impossible to delete ingredient.");
        }

        ingredientDAO.deleteByIdHashIngredient(ingredientIdHash);

    }

    /**
     * @param idHashIngredient
     * @param ingredient
     * @return
     */
    public Ingredient ingredientUpdate(String idHashIngredient, @Valid Ingredient ingredient) {

        checkArgument(!ingredient.getName().isEmpty(), "Ingredient name must not be empty.");

        IngredientDTO ingredientDTO = ingredientDAO.findByIdHashIngredient(idHashIngredient);

        Integer idCategory = categoryService.getIdCategoryByName(ingredient.getCategory());
        ingredientDTO.setIdCategory(idCategory);

        Integer idMeasureUnit = measureUnitService.getIdMesureUnitByName(ingredient.getMeasureUnit());
        ingredientDTO.setIdMesureUnit(idMeasureUnit);

        ingredientDTO.setName(ingredient.getName());

        return ingredientConverter.convertIngredientDTOInIngredientClient(ingredientDAO.save(ingredientDTO));
    }

    /**
     * @param ingredientIdHash
     * @param ingredient
     * @return
     */
    public Ingredient ingredientPatch(String ingredientIdHash, @Valid Ingredient ingredient) {

//        IngredientDTO ingredientDTO = ingredientDAO.findByIdHashIngredient(ingredientIdHash);
//
//        if (!ingredientDTO.getName().equals(ingredient.getName()) && !ingredient.getName().isEmpty()) {
//            ingredientDTO.setName(ingredient.getName());
//        }
//
//        String categoryName = categoryService.getCategoryNameById(ingredientDTO.getIdCategory());
//        if (!categoryName.equals(ingredient.getCategory().toString())) {
//
//            Integer idCategory = categoryService.getIdCategoryByName(ingredient.getCategory());
//
//            ingredientDTO.setIdCategory(idCategory);
//        }
//
//        String measureUnitName = measureUnitService.getMeasureUnitNameById(ingredientDTO.getIdMesureUnit());
//        if (!measureUnitName.equals(ingredient.getMeasureUnit().toString())) {
//
//            Integer idMeasureUnit = measureUnitService.getIdMesureUnitByName(ingredient.getMeasureUnit());
//
//            ingredientDTO.setIdMesureUnit(idMeasureUnit);
//        }
//
//        return ingredientConverter.convertIngredientDTOInIngredientClient(ingredientDAO.save(ingredientDTO));

        return null;
    }


}
