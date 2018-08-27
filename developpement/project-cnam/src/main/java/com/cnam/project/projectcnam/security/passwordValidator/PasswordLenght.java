package com.cnam.project.projectcnam.security.passwordValidator;

import com.cnam.project.projectcnam.security.exception.PasswordException;
import com.cnam.project.projectcnam.service.exception.ServiceException;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

public class PasswordLenght implements PasswordRules {


    @Override
    public boolean validate(String password) {

        // one letter : "*\\p{L}.*"
        // one digit : "*\\p{N}.*"

        if (!password.matches("^(.{8,50}$)")) {

            throw new PasswordException("The password length must be between 8 and 50 character");
        }
        return true;
    }
}
