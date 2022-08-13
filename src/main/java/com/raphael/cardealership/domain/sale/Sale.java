package com.raphael.cardealership.domain.sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raphael.cardealership.domain.car.Car;
import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.shared.EntityValidationException;
import com.raphael.cardealership.domain.shared.RegexPattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "saleId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    @JsonProperty("profit")
    public int calculateProfit() {
        return price - car.acquisitionPrice();
    }
}
