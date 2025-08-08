package com.ratingservice.ratingservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("Resource Not Found !!!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
