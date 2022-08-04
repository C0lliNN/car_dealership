package com.raphael.cardealership.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acquisitions")
@Embeddable
public class Acquisition {
    @Id
    private String carId;
    private LocalDate date;
    private int price;
    private AcquisitionSource source;
}
