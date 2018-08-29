package com.cnam.project.projectcnam.bdd.DAO;

import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.bdd.exception.DAOException;
import com.cnam.project.projectcnam.bdd.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class UserDAO {

    private Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    UserRepository userRepository;

    public UserDTO saveUser(UserDTO user) {

        logger.debug("[saveUser] is called. user.login : {}", user.getLogin());

        try {

            return userRepository.save(user);

        } catch (Exception e) {

            throw new DAOException("Impossible to save user.");
        }
    }

    /**
     * Get an user database side by his login.
     *
     * @param login User's login.
     * @return {@link UserDTO} User database side.
     */
    public UserDTO getUserByLogin(String login) {

        checkArgument(!login.isEmpty(), "Login is mandatory.");

        logger.debug("[getUserByLogin] is called. login : {}", login);

        UserDTO userDTO = userRepository.findByLogin(login);

        if (userDTO == null) {

            throw new NotFoundException("The User login is not found.");
        }

        logger.debug("[getUserByLogin] User is find. userDTO.getLogin : {}", userDTO.getLogin());

        return userDTO;
    }

    /**
     * Get an user database side by his identifier.
     *
     * @param idUser User's identifier.
     * @return {@link UserDTO} User database side.
     */
    public UserDTO getUserById(String idUser) {

        checkArgument(!idUser.isEmpty(), "User identifier is mandatory.");

        logger.debug("[getUserById] is called. idUser : {}", idUser);

        UserDTO userDTO = userRepository.findByIdHashUser(idUser);

        if (userDTO == null) {

            throw new NotFoundException("User not found.");
        }

        logger.debug("[getUserById] is find. userDTO.login : {}", userDTO.getLogin());

        return userDTO;
    }
}
