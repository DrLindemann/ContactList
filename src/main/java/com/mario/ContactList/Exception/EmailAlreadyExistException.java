package com.mario.ContactList.Exception;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException (String message){
        super(message);
    }

}
