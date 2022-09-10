package com.raphael.cardealership.infrastructure.auth.usecase;

public interface PasswordEncoder {
    String hashPassword(String password);
    boolean comparePasswordAndHash(String password, String hash);
}
