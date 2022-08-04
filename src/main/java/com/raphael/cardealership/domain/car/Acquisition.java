package com.raphael.cardealership.domain.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @JsonIgnore
    private String carId;
    private LocalDate date;
    private int price;

    @Enumerated(EnumType.STRING)
    private AcquisitionSource source;

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "carId")
    private Car car;
}
