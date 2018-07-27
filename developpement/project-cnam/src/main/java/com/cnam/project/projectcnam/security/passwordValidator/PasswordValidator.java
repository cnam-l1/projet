package com.cnam.project.projectcnam.security.passwordValidator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordValidator {

    private List<PasswordRules> passwordRulesList = new ArrayList<>();

    public PasswordValidator() {

        this.passwordRulesList.add(new PasswordContainsOneDigit());
        this.passwordRulesList.add(new PasswordContainsUpperCase());
        this.passwordRulesList.add(new PasswordLenght());

    }

    public boolean validatePassword(String password) {

        for (PasswordRules passwordRules : passwordRulesList) {

            passwordRules.validate(password);

        }

        return true;
    }
}
