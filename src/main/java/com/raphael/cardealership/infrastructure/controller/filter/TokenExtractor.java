package com.raphael.cardealership.infrastructure.controller.filter;

import com.raphael.cardealership.domain.auth.User;

public interface TokenExtractor {
    User extractUserFromToken(String token);
}
