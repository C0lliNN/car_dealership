package com.raphael.cardealership.domain.auth;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder(toBuilder = true)
public class User {
    Long id;
    String name;
    String email;
    @With
    String password;
}
