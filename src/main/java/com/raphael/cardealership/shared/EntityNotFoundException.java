package com.raphael.cardealership.shared;

public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }
}
