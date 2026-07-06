package com.zero;

public class AnimalNameException extends RuntimeException{
    public AnimalNameException(){}

    public AnimalNameException(String message){
        super(message);
    }
}
