package com.cnam.project.projectcnam.exception.model;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

public class Error {

    String message;
    int code;

    public Error() {
    }

    public Error(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
