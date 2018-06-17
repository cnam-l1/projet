package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.dao.model.IngredientDao;
import com.cnam.project.projectcnam.dao.model.UserDao;
import com.cnam.project.projectcnam.service.AuthService;
import com.cnam.project.projectcnam.service.IngredientService;
import com.cnam.project.projectcnam.service.UserService;
import com.cnam.project.projectcnam.service.model.Credentials;
import io.swagger.annotations.ApiParam;
import io.swagger.api.IngredientApi;
import io.swagger.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@RestController
public class IngredientController implements IngredientApi {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    UserService userService;

    @Autowired
    AuthService auth;

    public ResponseEntity<Ingredient> ingredientCreate(@Valid @RequestBody Ingredient ingredient) {

//        Credentials credentials = auth.getAndValidCredentials();
//
//        UserDao userDao = userService.getUser(credentials);
//
//        String idIngredient = ingredientService.ingredientCreate(credentials, userDao, ingredient);
//
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .path("/customers/{id}").buildAndExpand(idIngredient);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriComponents.toUri());
//
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);

        return null;
    }

    @Override
    public ResponseEntity<List<Ingredient>> ingredientFind() {

//        Credentials credentials = auth.getAndValidCredentials();
//
//        UserDao userDao = userService.getUser(credentials);
//
//        List<IngredientDao> ingredientList = ingredientService.ingredientFind(credentials);
//
//        return new ResponseEntity<>(ingredientList, HttpStatus.CREATED);

        return null;
    }

    @Override
    public ResponseEntity<Void> ingredientDelete(@PathVariable("ingredientId") String ingredientId) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientGet(@PathVariable("ingredientId") String ingredientId) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientPatch(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> ingredientUpdate(@PathVariable("ingredientId") String ingredientId, @Valid @RequestBody Ingredient ingredient) {

        return null;
    }
}
