package com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.exception;

public class ObjectNotFoundException extends RuntimeException{


    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
