package com.raphael.cardealership.car;

import com.raphael.cardealership.shared.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public Car getCar(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The car with the id '%s' was not found", id));
    }

    public Car createCar(Car car) {
        car.setId(UUID.randomUUID().toString());
        car.setStatus(CarStatus.ACTIVE);

        repository.save(car);
        return car;
    }

    public void updateCar(String id, Car newCar) {
        Car existingCar = getCar(id);

        existingCar.setName(newCar.getName());
        existingCar.setBrand(newCar.getBrand());
        existingCar.setStatus(newCar.getStatus());
        existingCar.setType(newCar.getType());
        existingCar.setColor(newCar.getColor());
        existingCar.setChassis(newCar.getChassis());
        existingCar.setMileage(newCar.getMileage());
        existingCar.setReleaseYear(newCar.getReleaseYear());
        existingCar.setAcquisition(newCar.getAcquisition());
        existingCar.setPhotos(newCar.getPhotos());

        existingCar.validate();

        repository.save(existingCar);
    }
}
