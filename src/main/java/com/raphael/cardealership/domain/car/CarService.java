package com.raphael.cardealership.domain.car;

import com.raphael.cardealership.domain.shared.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCar(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The car with the id '%s' was not found", id));
    }

    @Transactional
    public Car createCar(Car car) {
        String carId = UUID.randomUUID().toString();
        car.setId(carId);
        car.setStatus(CarStatus.ACTIVE);

        car.getPhotos().forEach(p -> p.setCarId(carId));
        car.getAcquisition().setCarId(carId);

        return carRepository.save(car);
    }

    @Transactional
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

        newCar.getAcquisition().setCarId(existingCar.getId());
        existingCar.setAcquisition(newCar.getAcquisition());

        newCar.getPhotos().forEach(p -> p.setCarId(existingCar.getId()));
        existingCar.getPhotos().clear();
        existingCar.getPhotos().addAll(newCar.getPhotos());

        carRepository.save(existingCar);
    }
}
