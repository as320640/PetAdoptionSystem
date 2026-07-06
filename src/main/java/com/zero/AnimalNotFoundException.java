package com.zero;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(){}

    public AnimalNotFoundException(String message){
        super(message);
    }
}
