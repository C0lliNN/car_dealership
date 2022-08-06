package com.raphael.cardealership.domain.car;

import com.raphael.cardealership.domain.shared.EntityValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

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

    private String name;
    private String brand;
    private String color;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @Enumerated(EnumType.STRING)
    private CarType type;
    private String chassis;
    private int mileage;
    private int releaseYear;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "carId", referencedColumnName = "id")
    private Acquisition acquisition;

    @OneToMany
    @JoinColumn(name = "carId", referencedColumnName = "id")
    @ToString.Exclude
    private List<Photo> photos;

    public boolean isSold() {
        return status == CarStatus.SOLD;
    }

    public void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new EntityValidationException("name", "this field is required");
        }

        if (brand == null || brand.trim().isEmpty()) {
            throw new EntityValidationException("brand", "this field is required");
        }

        if (color == null || color.trim().isEmpty()) {
            throw new EntityValidationException("color", "this field is required");
        }

        if (status == null) {
            throw new EntityValidationException("status", "this field is required");
        }

        if (chassis == null || chassis.trim().isEmpty()) {
            throw new EntityValidationException("chassis", "this field is required");
        }

        if (mileage > 0) {
            throw new EntityValidationException("mileage", "this field must be a positive number");
        }

        if (releaseYear < 1950 || releaseYear > 2300) {
            throw new EntityValidationException("mileage", "this field value must be between 1950 and 2300");
        }

        if (acquisition == null) {
            throw new EntityValidationException("acquisition", "this field is required");
        }

        if (acquisition.getSource() == null) {
            throw new EntityValidationException("acquisition.source", "this field is required");
        }

        if (acquisition.getDate() == null) {
            throw new EntityValidationException("acquisition.date", "this field is required");
        }

        if (acquisition.getPrice() > 0) {
            throw new EntityValidationException("acquisition.price", "this field must be a positive number");
        }

        if (photos != null && !photos.isEmpty()) {
            photos.forEach(photo -> {
                if (photo.getUrl() == null  || photo.getUrl().trim().isEmpty()) {
                    throw new EntityValidationException("photos.url", "this field is required");
                }
            });
        }
    }

    public int acquisitionPrice() {
        return acquisition.getPrice();
    }
}
