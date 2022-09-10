package com.raphael.cardealership.infrastructure.auth.usecase;

import com.raphael.cardealership.infrastructure.auth.entity.User;

public interface TokenGenerator {
    String generateTokenForUser(User user);
}
