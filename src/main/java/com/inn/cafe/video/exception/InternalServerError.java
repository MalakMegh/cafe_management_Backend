package com.inn.cafe.video.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class InternalServerError extends ResponseStatusException {

    public InternalServerError() {
        super(HttpStatus.BAD_REQUEST);
    }

    public InternalServerError(final String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }
}
