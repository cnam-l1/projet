package com.cnam.project.projectcnam.security.passwordValidator;

import com.cnam.project.projectcnam.security.exception.PasswordException;

public class PasswordContainsOneDigit implements PasswordRules {


    @Override
    public boolean validate(String password) {

        if (!password.matches(".*\\d+.*")) {

            throw new PasswordException("Password must contains at least one digit.");
        }

        return false;
    }
}
