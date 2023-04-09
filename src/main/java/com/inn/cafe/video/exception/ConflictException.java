package com.inn.cafe.video.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictException extends ResponseStatusException {

    public ConflictException() {
        super(HttpStatus.CONFLICT);
    }

    public ConflictException(final String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
