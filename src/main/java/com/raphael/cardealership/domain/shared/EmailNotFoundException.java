package com.raphael.cardealership.domain.shared;

public class EmailNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmailNotFoundException(final String message, Object... args) {
        super(String.format(message, args));
    }
}
