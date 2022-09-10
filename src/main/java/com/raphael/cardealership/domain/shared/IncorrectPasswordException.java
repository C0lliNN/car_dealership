package com.raphael.cardealership.domain.shared;

public class IncorrectPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncorrectPasswordException(final String message) {
        super(message);
    }
}
