package com.cnam.project.projectcnam.security.requestValidator;

import com.cnam.project.projectcnam.security.exception.RequestException;
import org.springframework.stereotype.Component;

@Component
public class RequestContainsAuthHeader implements RequestRules {


    @Override
    public boolean validate(String authorization) {

        if (authorization == null && !authorization.startsWith("Basic")) {

            throw new RequestException("Authorization header is mandatory.");

        }

        return true;
    }
}
