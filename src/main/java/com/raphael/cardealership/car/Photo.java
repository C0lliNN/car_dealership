package com.raphael.cardealership.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "photos")
public class Photo {
    private String carId;
    private String description;
    // Placing this as it's a JPA requirement
    @Id
    private String url;
}
