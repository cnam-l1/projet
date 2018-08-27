package com.cnam.project.projectcnam.security.requestValidator;

import com.cnam.project.projectcnam.bdd.DAO.UserDAO;
import com.cnam.project.projectcnam.bdd.DTO.UserDTO;
import com.cnam.project.projectcnam.security.exception.RequestException;
import com.cnam.project.projectcnam.security.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Component
public class CredentialsIsValid implements RequestRules {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean validate(String authorization) {

        String[] requestCredentials = getCredentialsInRequestHeader(authorization);

        String login = requestCredentials[0];
        String password = requestCredentials[1];

        if (!areValidLoginAndPassword(login, password)) {

            throw new RequestException("Invalid credentials.");
        }

        if (login.isEmpty() && password.isEmpty()) {

            throw new RequestException("invalid login or password");
        }

        credentials.setLogin(login);
        credentials.setPassword(password);

        return false;
    }

    public Credentials getCredentials(){

        return credentials;
    }

    private String[] getCredentialsInRequestHeader(String authorization) {

        String base64Credentials = authorization.substring("Basic".length()).trim();
        String requestCredentials = new String(Base64.getDecoder().decode(base64Credentials),
                Charset.forName("UTF-8"));

        return requestCredentials.split(":", 2);
    }

    private Boolean areValidLoginAndPassword(String login, String password) {

        UserDTO userDTO = userDAO.getUserByLogin(login);

        boolean bool = passwordEncoder.matches(password, userDTO.getPassword());

        System.out.println(bool);

        return bool;
    }
}
