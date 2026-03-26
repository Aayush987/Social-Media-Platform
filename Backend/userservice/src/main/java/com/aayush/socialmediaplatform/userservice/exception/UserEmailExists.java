package com.aayush.socialmediaplatform.userservice.exception;

public class UserEmailExists extends RuntimeException {
    public UserEmailExists(String message) {
        super(message);
    }
}
