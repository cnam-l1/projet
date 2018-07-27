package com.cnam.project.projectcnam.converter;

import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UserConverter {

    private Logger logger = LoggerFactory.getLogger(UserConverter.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Convert user client side in client database side.
     *
     * @param user {@link User} User client side.
     * @return User database side.
     */
    public UserDTO convertUserClientInUserDao(@Valid User user) {

        logger.debug("[UserService] [convertUserClientInUserDao] is called. user.id : {}", user.getIdUser());

        UserDTO userDTO = new UserDTO();

        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(passwordEncoder.encode(user.getPassword()));
        userDTO.setIdHashUser(user.getIdUser());

        return userDTO;
    }

    /**
     * Convert user database side in user client side.
     *
     * @param userDTO {@link UserDTO} User database side.
     * @return User client side.
     */
    public User convertUserDAOInUserClient(UserDTO userDTO) {

        logger.debug("[UserService] [convertUserDAOInUserClient] is called. userDTO.id : {}", userDTO.getIdHashUser());

        User newUser = new User();

        newUser.setIdUser(userDTO.getIdHashUser());
        newUser.setLogin(userDTO.getLogin());
        newUser.setPassword(userDTO.getPassword());

        return newUser;
    }
}
