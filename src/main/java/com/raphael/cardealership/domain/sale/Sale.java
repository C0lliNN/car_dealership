package com.raphael.cardealership.domain.sale;

import com.raphael.cardealership.domain.car.Car;
import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.shared.EntityValidationException;
import com.raphael.cardealership.domain.shared.RegexPattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

    @ManyToOne
    @JoinTable(name = "customers")
    @JoinColumn(name = "saleId", updatable = false, insertable = false)
    private Customer customer;

    @JoinTable(name = "sellers")
    @JoinColumn(name = "sellers.id", updatable = false, insertable = false)
    private Seller seller;

    @ManyToOne
    @JoinTable(name = "cars")
    @JoinColumn(name = "cars.id", insertable = false, updatable = false)
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
