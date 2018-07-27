package com.cnam.project.projectcnam.security.requestValidator;

import com.cnam.project.projectcnam.security.model.Credentials;

import javax.servlet.http.HttpServletRequest;

public interface RequestRules {

    public Credentials credentials = new Credentials();

    public boolean validate(String authorization);
}
