package com.raphael.cardealership.infrastructure.auth.web;

import com.raphael.cardealership.infrastructure.auth.entity.User;

public interface TokenExtractor {
    User extractUserFromToken(String token);
}
