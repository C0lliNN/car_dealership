package com.raphael.cardealership.domain.auth;


import lombok.Value;
import lombok.With;

@Value
public class UserResponse {
    String id;
    String name;
    String email;
    @With
    String token;

    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                null
        );
    }
}
