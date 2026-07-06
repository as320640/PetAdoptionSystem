package com.zero;

public class DogEmptyException extends RuntimeException{
    public DogEmptyException(){}

    public DogEmptyException(String message){
        super(message);
    }
}
