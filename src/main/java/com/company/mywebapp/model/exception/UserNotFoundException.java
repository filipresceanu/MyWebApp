package com.company.mywebapp.model.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
