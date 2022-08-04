package com.raphael.cardealership.controller;

import com.raphael.cardealership.car.Car;
import com.raphael.cardealership.car.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable("id") String carId) {
        return carService.getCar(carId);
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("/cars/{id}")
    public void updateCar(@PathVariable("id") String carId, Car car) {
        carService.updateCar(carId, car);
    }
}
