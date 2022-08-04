package com.raphael.cardealership.domain.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "photos")
public class Photo {
    @JsonIgnore
    private String carId;
    private String description;
    // Placing this as it's a JPA requirement
    @Id
    private String url;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "carId", insertable = false, updatable = false)
    private Car car;
}
