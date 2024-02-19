package com.example.JpaAssignment.demo.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message){
        super(message);
    }

}
