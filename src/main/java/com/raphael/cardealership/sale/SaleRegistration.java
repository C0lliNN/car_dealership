package com.raphael.cardealership.sale;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
public class SaleRegistration {
    @NotBlank(message = "the field is mandatory")
    String cardId;

    @NotBlank(message = "the field is mandatory")
    String sellerId;

    @NotBlank(message = "the field is mandatory")
    String customerName;

    @NotBlank(message = "the field is mandatory")
    @Email(message = "the field must be a valid email")
    String customerEmail;

    String customerPhone;
}
