package com.raphael.cardealership.domain.sale;

import com.raphael.cardealership.domain.car.Acquisition;
import com.raphael.cardealership.domain.car.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void calculateProfit() {
        int salePrice = 4000000;
        int acquisitionPrice = 3800000;

        Acquisition acquisition = new Acquisition();
        acquisition.setPrice(acquisitionPrice);

        Car car = new Car();
        car.setAcquisition(acquisition);

        Sale sale = new Sale();
        sale.setCar(car);
        sale.setPrice(salePrice);

        assertEquals(salePrice - acquisitionPrice, sale.calculateProfit());
    }
}