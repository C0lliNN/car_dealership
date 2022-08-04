package com.raphael.cardealership.domain.seller;

import com.raphael.cardealership.domain.shared.EntityValidationException;
import com.raphael.cardealership.domain.shared.RegexPattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    private String id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private SellerStatus status;
    private LocalDate joinDate;

    public boolean isActive() {
        return status == SellerStatus.ACTIVE;
    }

    public void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new EntityValidationException("name", "this field is required");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new EntityValidationException("email", "this field is required");
        }

        if (!Pattern.compile(RegexPattern.EMAIL).matcher(email).matches()) {
            throw new EntityValidationException("email", "this email is not valid");
        }

        if (status == null) {
            throw new EntityValidationException("status", "this field is required");
        }

        if (joinDate == null) {
            throw new EntityValidationException("joinDate", "this field is required");
        }

        if (joinDate.isBefore(LocalDate.of(2022, 1, 1))) {
            throw new EntityValidationException("joinDate", "this field requires a date after January 1st, 2022");
        }
    }
}
