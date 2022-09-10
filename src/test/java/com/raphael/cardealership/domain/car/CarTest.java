package com.raphael.cardealership.domain.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @EnumSource(CarStatus.class)
    void isSold(CarStatus status) {
        Car car = new Car();
        car.setStatus(status);
        assertEquals(status.equals(CarStatus.SOLD), car.isSold());
    }

    @Test
    void acquisitionPrice() {
        Acquisition acquisition = new Acquisition();
        acquisition.setPrice(1000);

        Car car = new Car();
        car.setAcquisition(acquisition);

        assertEquals(1000, car.acquisitionPrice());
    }
}