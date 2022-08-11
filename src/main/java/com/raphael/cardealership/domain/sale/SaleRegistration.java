package com.raphael.cardealership.domain.sale;

import com.raphael.cardealership.domain.shared.AfterPlatformLaunch;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Value
public class SaleRegistration {
    @NotBlank(message = "the field is mandatory")
    String carId;

    @NotBlank(message = "the field is mandatory")
    String sellerId;

    @NotBlank(message = "the field is mandatory")
    String customerName;

    @NotBlank(message = "the field is mandatory")
    @Email(message = "the field must be a valid email")
    String customerEmail;

    String customerPhone;

    @Positive(message = "the field must be a positive integer")
    int price;

    @NotNull(message = "this field is mandatory")
    @AfterPlatformLaunch(message = "the date must be after 2022")
    LocalDate date;
}
