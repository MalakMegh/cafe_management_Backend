package com.inn.cafe.video.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class InvalidDataException extends ResponseStatusException {
    public InvalidDataException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public InvalidDataException(final String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
