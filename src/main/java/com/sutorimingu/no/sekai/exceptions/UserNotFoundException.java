package com.sutorimingu.no.sekai.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }

    public UserNotFoundException(String name) {
        super("Could not find user " + name);
    }
}
