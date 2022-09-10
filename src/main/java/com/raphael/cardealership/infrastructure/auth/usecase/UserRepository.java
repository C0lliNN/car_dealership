package com.raphael.cardealership.infrastructure.auth.usecase;

import com.raphael.cardealership.infrastructure.auth.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
