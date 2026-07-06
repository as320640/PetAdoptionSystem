package com.zero;

public class ShelterEmptyException extends RuntimeException{
    public ShelterEmptyException(){}

    public ShelterEmptyException(String message){
        super(message);
    }
}
