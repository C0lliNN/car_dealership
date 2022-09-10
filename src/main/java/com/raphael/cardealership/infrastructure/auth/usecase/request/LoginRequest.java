package com.raphael.cardealership.infrastructure.auth.usecase.request;


import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
public class LoginRequest {
    @NotBlank(message = "the field is mandatory")
    @Email(message = "the field must be a valid email")
    String email;

    @NotBlank(message = "the field is mandatory")
    String password;
}