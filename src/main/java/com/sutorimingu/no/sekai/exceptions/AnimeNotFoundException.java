package com.sutorimingu.no.sekai.exceptions;

public class AnimeNotFoundException extends RuntimeException {

    public AnimeNotFoundException(Long id) {
        super("Could not find anime " + id);
    }

    public AnimeNotFoundException(String name) {
        super("Could not find anime " + name);
    }
}
