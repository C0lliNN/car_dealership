package com.raphael.cardealership.domain.shared;

public class EntityValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityValidationException(String field, String message) {
        super(String.format("Validation error on field '%s': %s", field, message));
    }
}
