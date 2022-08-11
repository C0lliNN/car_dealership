package com.raphael.cardealership.domain.sale;

import com.raphael.cardealership.domain.car.Car;
import com.raphael.cardealership.domain.car.CarRepository;
import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.seller.SellerRepository;
import com.raphael.cardealership.domain.shared.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public Sale registerNewSale(SaleRegistration saleRegistration) {
        Car car = carRepository.findById(saleRegistration.getCarId())
                .orElseThrow(() -> new EntityNotFoundException("Car the id '%s' was not found", saleRegistration.getCarId()));

        Seller seller = sellerRepository.findById(saleRegistration.getSellerId())
                .orElseThrow(() -> new EntityNotFoundException("Seller with id '%s' was not found.", saleRegistration.getSellerId()));

        Sale sale = new Sale();
        sale.setId(UUID.randomUUID().toString());
        Customer customer = new Customer(
                sale.getId(),
                saleRegistration.getCustomerName(),
                saleRegistration.getCustomerEmail(),
                saleRegistration.getCustomerPhone()
        );
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setCar(car);
        sale.setPrice(saleRegistration.getPrice());
        sale.setDate(saleRegistration.getDate());

        customerRepository.save(customer);
        saleRepository.save(sale);

        return sale;
    }

    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    public Sale getSale(String id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale with id '%s' was not found.", id));
    }
}
