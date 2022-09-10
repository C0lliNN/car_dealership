package com.raphael.cardealership.domain.auth;

public interface TokenGenerator {
    String generateTokenForUser(User user);
}
