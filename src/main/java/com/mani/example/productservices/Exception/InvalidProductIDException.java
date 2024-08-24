package com.mani.example.productservices.Exception;

public class InvalidProductIDException extends Exception{
    public InvalidProductIDException(){

    }
    public InvalidProductIDException(String message){
        super(message);
    }
}
