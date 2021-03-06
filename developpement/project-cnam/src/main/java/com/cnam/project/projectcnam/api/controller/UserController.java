package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.service.AuthorizationService;
import com.cnam.project.projectcnam.service.UserService;
import com.cnam.project.projectcnam.service.model.Credentials;
import io.swagger.api.UserApi;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@RestController
public class UserController implements UserApi {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<User> userCreate(@Valid @RequestBody User user) {

        checkArgument(user != null, "User is mandatory.");
        checkArgument(user.getLogin() != null, "Login is mandatory.");
        checkArgument(user.getPassword() != null, "Password is mandatory.");

        logger.debug("[UserController] [userCreate] is called. User.login : {}", user.getLogin());

        User userResponse = userService.userCreate(user);

        logger.debug("[UserController] [userCreate] User is created. User.id : {}", user.getIdUser());

        return new ResponseEntity<User>(userResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> userUpdate(@PathVariable("userId") String userId, @Valid @RequestBody User user) {

        checkArgument(user != null, "User is mandatory.");
        checkArgument(user.getLogin() != null, "Login is mandatory.");
        checkArgument(user.getPassword() != null, "Password is mandatory.");
        checkArgument(!userId.isEmpty(), "UserId must not be empty.");

        logger.debug("[UserController] [userUpdate] is called. userId : {}", userId);

        Credentials credentials = authorizationService.getAndValidCredentials();

        User userUpdated = userService.userUpdate(userId, user);

        logger.debug("[UserController] [userUpdate] User is updated. userUpdated.id : {}", userUpdated.getIdUser());

        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
    }

}
