package com.raphael.cardealership.infrastructure.auth;

import com.raphael.cardealership.domain.auth.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {
    private final BCryptPasswordEncoder encoder;

    public PasswordEncoderImpl() {
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String hashPassword(final String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean comparePasswordAndHash(final String password, final String hash) {
        return encoder.matches(password, hash);
    }
}
