package com.raphael.cardealership.infrastructure.auth.exception;

public class IncorrectPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncorrectPasswordException(final String message) {
        super(message);
    }
}
