package com.zero;

public class AnimalAgeIllegalException extends RuntimeException{
    public AnimalAgeIllegalException(){}

    public AnimalAgeIllegalException(String message){
        super(message);
    }
}
