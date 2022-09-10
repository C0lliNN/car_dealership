package com.raphael.cardealership.infrastructure.controller.filter;

import com.raphael.cardealership.infrastructure.auth.entity.User;

public interface TokenExtractor {
    User extractUserFromToken(String token);
}
