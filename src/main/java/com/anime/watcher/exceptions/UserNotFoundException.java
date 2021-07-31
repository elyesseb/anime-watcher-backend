package com.anime.watcher.exceptions;

/**
 * @author sei3
 * on 31/07/2021.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }

    public UserNotFoundException(String id) {
        super("Could not find user " + id);
    }
}
