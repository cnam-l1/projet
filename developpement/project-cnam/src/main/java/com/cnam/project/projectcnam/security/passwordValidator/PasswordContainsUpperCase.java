package com.cnam.project.projectcnam.security.passwordValidator;

import com.cnam.project.projectcnam.security.exception.PasswordException;

public class PasswordContainsUpperCase implements PasswordRules {

    @Override
    public boolean validate(String password) {

        if (!password.matches(".*[A-Z].*")) {

            throw new PasswordException("Password must contains at least one upper case.");
        }

        return true;
    }
}
