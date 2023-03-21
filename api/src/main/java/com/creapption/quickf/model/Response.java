package com.creapption.quickf.model;

import org.springframework.http.HttpStatus;

public class Response {
    public String message;
    public String errorMessage;
    public HttpStatus codeStatus;

    public Response(String message, String errorMessage, HttpStatus codeStatus){
        this.message = message;
        this.errorMessage = errorMessage;
        this.codeStatus = codeStatus;
    }

    public Response(String message, HttpStatus codeStatus) {
        this.message = message;
        this.codeStatus = codeStatus;
    }
}
