package com.cnam.project.projectcnam.converter;

import com.cnam.project.projectcnam.bdd.DTO.IngredientShoppingDTO;
import com.cnam.project.projectcnam.bdd.DTO.ShoppingDTO;
import io.swagger.model.Ingredient;
import io.swagger.model.Shopping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Component
public class ShoppingConverter {

    private Logger logger = LoggerFactory.getLogger(UserConverter.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IngredientConverter ingredientConverter;

    public ShoppingDTO convertShoppingClientInShoppingDTO(@Valid Shopping shopping, String idUser) {

        logger.debug("[convertShoppingClientInShoppingDTO] is called. shopping.idHash : {}", shopping.getIdShopping());

        ShoppingDTO shoppingDTO = new ShoppingDTO();

        shoppingDTO.setDate(shopping.getDate());
        shoppingDTO.setIdHashShopping(shopping.getIdShopping());
        shoppingDTO.setIdUser(Integer.parseInt(idUser));

        return shoppingDTO;
    }

    public Shopping convertShoppingDTOInShopping(ShoppingDTO shoppingDTO) {

        logger.debug("[convertShoppingDTOInShopping] is called. shoppingDTO.idHash : {}", shoppingDTO.getIdHashShopping());

        Shopping shopping = new Shopping();

        shopping.setDate(shoppingDTO.getDate());
        shopping.setIdShopping(shoppingDTO.getIdHashShopping());

        List<Ingredient> ingredientList = new ArrayList<>();

        if (shoppingDTO.getIngredientShoppingDTOList() != null) {

            for (IngredientShoppingDTO ingredientShoppingDTO : shoppingDTO.getIngredientShoppingDTOList()) {

                Ingredient ingredient = ingredientConverter.convertIngredientDTOInIngredientClient(ingredientShoppingDTO.getIngredientDTO());
                ingredient.setQuantity(ingredientShoppingDTO.getQuantity());
                ingredientList.add(ingredient);

            }
        }

        shopping.setIngredientList(ingredientList);

        return shopping;
    }
}
