package com.raphael.cardealership.sale;

import com.raphael.cardealership.car.Car;
import com.raphael.cardealership.seller.Seller;
import com.raphael.cardealership.shared.EntityValidationException;
import com.raphael.cardealership.shared.RegexPattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    private String id;

    private LocalDate date;
    private int value;

    @OneToOne
    private Customer customer;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Car car;

    public int calculateProfit() {
        return value - car.acquisitionPrice();
    }

    public void validate() {
        if (date == null) {
            throw new EntityValidationException("date", "this field is required");
        }

        if (value > 0) {
            throw new EntityValidationException("mileage", "this field must be a positive number");
        }

        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new EntityValidationException("customer.name", "this field is required");
        }

        if (customer.getEmail() == null || customer.getEmail().trim().isEmpty()) {
            throw new EntityValidationException("customer.email", "this field is required");
        }

        if (!Pattern.compile(RegexPattern.EMAIL).matcher(customer.getEmail()).matches()) {
            throw new EntityValidationException("customer.email", "this email is not valid");
        }

        if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
            throw new EntityValidationException("customer.phone", "this field is required");
        }
    }
}
