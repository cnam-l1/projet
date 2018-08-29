package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.bdd.DAO.IngredientDAO;
import com.cnam.project.projectcnam.bdd.DAO.ShoppingDAO;
import com.cnam.project.projectcnam.bdd.DAO.UserDAO;
import com.cnam.project.projectcnam.bdd.DTO.IngredientDTO;
import com.cnam.project.projectcnam.bdd.DTO.IngredientShoppingDTO;
import com.cnam.project.projectcnam.bdd.DTO.ShoppingDTO;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.converter.ShoppingConverter;
import com.cnam.project.projectcnam.security.model.Credentials;
import io.swagger.model.Ingredient;
import io.swagger.model.Shopping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingService {

    Logger logger = LoggerFactory.getLogger(ShoppingService.class);

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    ShoppingConverter shoppingConverter;

    public Shopping create(Credentials credentials, @Valid Shopping shopping) {

        logger.debug("[createShopping] is called. shopping.id : {}", shopping.getIdShopping());

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        shopping.setIdShopping(UUID.randomUUID().toString());
        ShoppingDTO shoppingDTO = shoppingConverter.convertShoppingClientInShoppingDTO(shopping, userDTO.getIdUser().toString());

        List<IngredientShoppingDTO> ingredientShoppingDTOList = new ArrayList<>();

        if (shopping.getIngredientList() != null) {

            for (Ingredient ingredient : shopping.getIngredientList()) {

                IngredientShoppingDTO ingredientShoppingDTO = new IngredientShoppingDTO();

                IngredientDTO ingredientDTO = ingredientDAO.findByIdHashIngredient(ingredient.getIdIngredient());

                ingredientShoppingDTO.setIngredientDTO(ingredientDTO);

                ingredientShoppingDTO.setQuantity(ingredient.getQuantity());

                ingredientShoppingDTO.setShoppingDTO(shoppingDTO);

                ingredientShoppingDTOList.add(ingredientShoppingDTO);
            }
        }

        shoppingDTO.setIngredientShoppingDTOList(ingredientShoppingDTOList);

        Shopping newShopping = shoppingConverter.convertShoppingDTOInShopping(shoppingDAO.saveShopping(shoppingDTO));

        return newShopping;
    }

    public List<Shopping> shoppingFind(Credentials credentials) {

        logger.debug("[shoppingFind] is called.");

        UserDTO userDTO = userDAO.getUserByLogin(credentials.getLogin());

        List<ShoppingDTO> shoppingDTOList = shoppingDAO.findAll(userDTO.getIdUser().intValue());

        List<Shopping> shoppingList = new ArrayList<>();

        for (ShoppingDTO recipeDTO : shoppingDTOList) {

            Shopping shopping = shoppingConverter.convertShoppingDTOInShopping(recipeDTO);

            shoppingList.add(shopping);
        }

        return shoppingList;
    }
}
