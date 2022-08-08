package com.raphael.cardealership.domain.car;

import com.raphael.cardealership.domain.shared.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final AcquisitionRepository acquisitionRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCar(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The car with the id '%s' was not found", id));
    }

    public Car createCar(Car car) {
        String carId = UUID.randomUUID().toString();
        car.setId(carId);
        car.setStatus(CarStatus.ACTIVE);

        car.validate();

        car.getAcquisition().setCarId(carId);
        acquisitionRepository.save(car.getAcquisition());

        car.setAcquisition(null);
        car.setPhotos(null);

        return carRepository.save(car);
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

        carRepository.save(existingCar);
    }
}
