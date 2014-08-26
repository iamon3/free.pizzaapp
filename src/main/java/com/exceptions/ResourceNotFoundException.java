package com.exceptions;

/**
 */
public class ResourceNotFoundException extends Exception {

    private String message;

    public ResourceNotFoundException(){}

    public ResourceNotFoundException(String msg){
        message = msg;
    }

    @Override
    public String toString() {
        return message;
    }
}
