package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.security.model.Credentials;
import com.cnam.project.projectcnam.security.requestValidator.RequestValidator;
import com.cnam.project.projectcnam.service.ShoppingService;
import io.swagger.api.ShoppingApi;
import io.swagger.model.Shopping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@RestController
public class ShoppingController implements ShoppingApi {

    Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    RequestValidator requestValidator;

    @Autowired
    ShoppingService shoppingService;

    @Override
    public ResponseEntity<Shopping> shoppingCreate(@Valid @RequestBody Shopping shopping) {

        logger.debug("[shoppingCreate] is called. shopping.id : {} ", shopping.getIdShopping());

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        Shopping newShopping = shoppingService.create(credentials, shopping);

        return new ResponseEntity<Shopping>(newShopping, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Shopping>> shoppingFind() {

        logger.debug("[shoppingFind] is called.");

        requestValidator.validateRequest();

        Credentials credentials = requestValidator.getCredentials();

        List<Shopping> shoppingList = shoppingService.shoppingFind(credentials);

        return new ResponseEntity<List<Shopping>>(shoppingList, HttpStatus.OK);

    }


}
