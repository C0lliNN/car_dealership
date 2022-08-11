package com.raphael.cardealership.domain.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.raphael.cardealership.domain.shared.AfterPlatformLaunch;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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

    @NotNull(message = "this field is mandatory")
    @AfterPlatformLaunch(message = "the date must be after 2022")
    private LocalDate date;

    @Positive(message = "the field must be positive")
    private int price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "the field is mandatory")
    private AcquisitionSource source;
}
