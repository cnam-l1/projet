package com.cnam.project.projectcnam.security.passwordValidator;

import com.cnam.project.projectcnam.security.exception.PasswordException;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

public class PasswordContainsOneDigit implements PasswordRules {


    @Override
    public boolean validate(String password) {

        if (!password.matches(".*\\d+.*")) {

            throw new PasswordException("Password must contains at least one digit.");
        }

        return false;
    }
}
