package com.raphael.cardealership.domain.auth;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class RegisterRequest {
    @NotBlank(message = "the field is mandatory")
    @Size(max = 150, message = "the field must contain at most {max} chars")
    String name;

    @NotBlank(message = "the field is mandatory")
    @Email(message = "the field must be a valid email")
    String email;

    @NotBlank(message = "the field is mandatory")
    @Size(min = 6, max = 20, message = "the field must contain between {min} and {max} chars")
    String password;

    public User toUser(String id) {
        return new User(id, name, email, password);
    }
}