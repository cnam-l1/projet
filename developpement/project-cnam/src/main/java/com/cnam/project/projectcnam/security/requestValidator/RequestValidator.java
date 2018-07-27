package com.cnam.project.projectcnam.security.requestValidator;

import com.cnam.project.projectcnam.security.model.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class RequestValidator {

    private Logger logger = LoggerFactory.getLogger(RequestValidator.class);

    @Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    private CredentialsIsValid credentialsIsValid;

    @Autowired
    private RequestContainsAuthHeader requestContainsAuthHeader;

    public RequestValidator() {


    }

    public void validateRequest() {

        String authorization = httpRequest.getHeader("Authorization");

        List<RequestRules> requestRulesList = new ArrayList<>();

        requestRulesList.add(requestContainsAuthHeader);
        requestRulesList.add(credentialsIsValid);

        for (RequestRules requestRules : requestRulesList) {

            requestRules.validate(authorization);
        }
    }

    public Credentials getCredentials() {

        return credentialsIsValid.getCredentials();
    }
}
