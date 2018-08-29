package com.cnam.project.projectcnam.security.requestValidator;

import com.cnam.project.projectcnam.security.model.Credentials;

import javax.servlet.http.HttpServletRequest;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

public interface RequestRules {

    public Credentials credentials = new Credentials();

    public boolean validate(String authorization);
}
