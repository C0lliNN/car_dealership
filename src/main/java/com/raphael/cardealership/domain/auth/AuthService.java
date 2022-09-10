package com.raphael.cardealership.domain.auth;

import com.raphael.cardealership.domain.shared.DuplicateEmailException;
import com.raphael.cardealership.domain.shared.EmailNotFoundException;
import com.raphael.cardealership.domain.shared.IncorrectPasswordException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import javax.annotation.ManagedBean;
import java.util.UUID;

@ManagedBean
@AllArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;

    public UserResponse login(LoginRequest request) {
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EmailNotFoundException("The email '%s' could not be found.", request.getEmail()));

        if (!passwordEncoder.comparePasswordAndHash(request.getPassword(), user.getPassword())) {
            throw new IncorrectPasswordException("The provided password is incorrect.");
        }

        return createUserResponseWithToken(user);
    }

    public UserResponse register(RegisterRequest request) {
        User user = request.toUser(UUID.randomUUID().toString());

        user.setPassword(passwordEncoder.hashPassword(user.getPassword()));

        try {
            user = repository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException("An user with the provided email is already registered.");
        }

        return createUserResponseWithToken(user);
    }

    private UserResponse createUserResponseWithToken(User user) {
        String token = tokenGenerator.generateTokenForUser(user);

        return UserResponse.fromUser(user).withToken(token);
    }
}
