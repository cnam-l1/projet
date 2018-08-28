package com.cnam.project.projectcnam.api.exception;

public class InternalServerError extends RuntimeException{

    public InternalServerError(String message) {
        super(message);
    }

    public InternalServerError(Throwable cause) {
        super(cause);
    }

    public InternalServerError(String message, Throwable cause) {
        super(message, cause);
    }
}