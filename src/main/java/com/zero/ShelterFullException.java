package com.zero;

public class ShelterFullException extends RuntimeException{
    public ShelterFullException(){}

    public ShelterFullException(String message){
        super(message);
    }
}
