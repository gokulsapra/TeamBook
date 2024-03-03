package com.springboot.TeamBook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    //takes message as argument and passes it to the parent class (RuntimeException)
    public ResourceNotFoundException(String message){
        super(message);
    }
}
