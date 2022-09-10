package com.raphael.cardealership.domain.auth;

import com.raphael.cardealership.domain.shared.EmailNotFoundException;
import com.raphael.cardealership.domain.shared.IncorrectPasswordException;
import lombok.AllArgsConstructor;

import javax.annotation.ManagedBean;

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
        User user = request.toUser();

        user = user.withPassword(passwordEncoder.hashPassword(user.getPassword()));
        user = repository.save(user);

        return createUserResponseWithToken(user);
    }

    private UserResponse createUserResponseWithToken(User user) {
        String token = tokenGenerator.generateTokenForUser(user);

        return UserResponse.fromUser(user).withToken(token);
    }
}
