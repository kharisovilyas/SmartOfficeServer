package com.smartoffice.server.features.response.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("User with this username already exists");
    }
}

