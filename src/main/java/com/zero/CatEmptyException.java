package com.zero;

public class CatEmptyException extends RuntimeException{
    public CatEmptyException(){}

    public CatEmptyException(String message){
        super(message);
    }
}
