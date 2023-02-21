package com.creapption.quickf.model;

public class Response {
    public String message;
    public String errorMessage;
    public Integer codeStatus;

    public Response(String message){
        this.message = message;
    }
}
