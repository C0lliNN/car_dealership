package com.raphael.cardealership.infrastructure.auth.exception;

public class DuplicateEmailException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicateEmailException(final String message, Object... args) {
        super(String.format(message, args));
    }
}