package com.raphael.cardealership.domain.car;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private String id;

    @NotBlank(message = "this field is mandatory")
    private String name;

    @NotBlank(message = "this field is mandatory")
    private String brand;

    @NotBlank(message = "this field is mandatory")
    private String color;

    @NotNull(message = "this field is mandatory")
    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @NotNull(message = "this field is mandatory")
    @Enumerated(EnumType.STRING)
    private CarType type;

    @NotBlank(message = "this field is mandatory")
    private String chassis;

    @Positive(message = "the field must be positive")
    private int mileage;
    private int releaseYear;

    @NotNull(message = "this field is mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "carId", referencedColumnName = "id")
    private Acquisition acquisition;

    @NotNull(message = "this field is mandatory")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carId", referencedColumnName = "id")
    @ToString.Exclude
    private Set<Photo> photos;

    public boolean isSold() {
        return status == CarStatus.SOLD;
    }

    public int acquisitionPrice() {
        return acquisition.getPrice();
    }
}
