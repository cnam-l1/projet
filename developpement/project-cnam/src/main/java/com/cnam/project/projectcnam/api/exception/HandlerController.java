package com.cnam.project.projectcnam.api.exception;

import com.cnam.project.projectcnam.api.exception.model.Error;
import com.cnam.project.projectcnam.bdd.exception.DAOException;
import com.cnam.project.projectcnam.security.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@ControllerAdvice
public class HandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> defaultExceptionResponse(Exception e) {

        Error error = new Error();
        error.setMessage("An error occured.");
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Error> notFoundExceptionResponse(NotFoundException nfe) {

        Error error = new Error();
        error.setMessage(nfe.getMessage());
        error.setCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> badRequestExceptionResponse(BadRequestException bre) {

        Error error = new Error();
        error.setMessage(bre.getMessage());
        error.setCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<Error> RequestExceptionResponse(RequestException re) {

        Error error = new Error();
        error.setMessage(re.getMessage());
        error.setCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> illegalArgumentResponse(IllegalArgumentException ial) {

        Error error = new Error();
        error.setMessage(ial.getMessage());
        error.setCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DAOException.class)
    public ResponseEntity<Error> daoExceptionResponse(DAOException daoe) {

        Error error = new Error();
        error.setMessage(daoe.getMessage());
        error.setCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Error> internalServerExceptionResponse(InternalServerError ise) {

        Error error = new Error();
        error.setMessage(ise.getMessage());
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
