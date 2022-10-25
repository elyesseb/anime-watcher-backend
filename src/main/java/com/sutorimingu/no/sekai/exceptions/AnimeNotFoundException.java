package com.sutorimingu.no.sekai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author sei3
 * on 31/07/2021.
 */

public class AnimeNotFoundException extends RuntimeException {

    public AnimeNotFoundException(Long id) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Could not find anime" + id
        );
    }

    public AnimeNotFoundException(String name) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Could not find anime" + name
        );
    }
}
