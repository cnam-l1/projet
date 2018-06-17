package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.exception.model.UnauthorizedException;
import com.cnam.project.projectcnam.service.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class AuthService {

    @Autowired
    HttpServletRequest httpRequest;

    public Credentials getAndValidCredentials() {

        String authorization = httpRequest.getHeader("Authorization");

        Credentials credentials = null;

        if (authorization != null && authorization.startsWith("Basic")) {

            String base64Credentials = authorization.substring("Basic".length()).trim();
            String requestCredentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));

            final String[] values = requestCredentials.split(":", 2);

            if( !values[0].isEmpty() && !values[1].isEmpty()  ){

                credentials = new Credentials();
                credentials.setLogin(values[0]);
                credentials.setPassword(values[1]);

            }
            else{

                throw new UnauthorizedException("invalid login or password");

            }
        }
        else{

            throw new UnauthorizedException("Authorization header is mandatory");
        }

        return credentials;
    }
}
