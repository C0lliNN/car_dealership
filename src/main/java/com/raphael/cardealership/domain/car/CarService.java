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
    private final AcquisitionRepository acquisitionRepository;
    private final PhotoRepository photoRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCar(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The car with the id '%s' was not found", id));
    }

    @Transactional
    public Car createCar(Car car) {
        car.setId(UUID.randomUUID().toString());
        car.setStatus(CarStatus.ACTIVE);
        car.validate();

        saveAcquisition(car);
        savePhotos(car);

        return carRepository.save(car);
    }

    private void saveAcquisition(Car car) {
        car.getAcquisition().setCarId(car.getId());
        acquisitionRepository.save(car.getAcquisition());
        car.setAcquisition(null);
    }

    private void savePhotos(Car car) {
        car.getPhotos().forEach(p -> p.setCarId(car.getId()));
        photoRepository.saveAll(car.getPhotos());
        car.setPhotos(null);
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

        existingCar.validate();

        updateAcquisition(existingCar, newCar);
        updatePhotos(existingCar, newCar);

        carRepository.save(existingCar);
    }

    private void updateAcquisition(Car existing, Car newCar) {
        newCar.getAcquisition().setCarId(existing.getId());
        acquisitionRepository.delete(existing.getAcquisition());
        acquisitionRepository.save(newCar.getAcquisition());
        existing.setAcquisition(null);
    }

    private void updatePhotos(Car existing, Car newCar) {
        newCar.getPhotos().forEach(p -> p.setCarId(existing.getId()));
        photoRepository.deleteAll(existing.getPhotos());
        photoRepository.saveAll(newCar.getPhotos());
        existing.setPhotos(null);
    }
}
