package com.cnam.project.projectcnam.api.controller;

import com.cnam.project.projectcnam.service.UserService;
import io.swagger.api.UserApi;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi{

    @Autowired
    UserService userService;

    @RequestMapping(method = GET, value = "{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String id ){

        User user = userService.getUser(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = GET)
    public ResponseEntity<List<User>> userFind(){

        List<User> user = userService.getUserList();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
