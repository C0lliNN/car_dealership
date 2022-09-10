package com.raphael.cardealership.domain.auth;

public interface PasswordEncoder {
    String hashPassword(String password);
    boolean comparePasswordAndHash(String password, String hash);
}
