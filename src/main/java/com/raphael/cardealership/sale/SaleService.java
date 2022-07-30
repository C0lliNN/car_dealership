package com.raphael.cardealership.sale;

import com.raphael.cardealership.car.Car;
import com.raphael.cardealership.car.CarRepository;
import com.raphael.cardealership.seller.Seller;
import com.raphael.cardealership.seller.SellerRepository;
import com.raphael.cardealership.shared.EntityNotFoundException;
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

    @Transactional
    public Sale registerNewSale(SaleRegistration saleRegistration) {
        Car car = carRepository.findById(saleRegistration.getCardId())
                .orElseThrow(() -> new EntityNotFoundException("Car the id '%s' was not found", saleRegistration.getCardId()));

        Seller seller = sellerRepository.findById(saleRegistration.getSellerId())
                .orElseThrow(() -> new EntityNotFoundException("Seller with id '%s' was not found.", saleRegistration.getSellerId()));

        Sale sale = new Sale();
        sale.setId(UUID.randomUUID().toString());
        sale.setDate(LocalDate.now());
        Customer customer = new Customer(
                sale.getId(),
                saleRegistration.getCustomerName(),
                saleRegistration.getCustomerEmail(),
                saleRegistration.getCustomerPhone()
        );
        sale.setCustomer(customer);
        sale.setSeller(seller);
        sale.setCar(car);

        sale.validate();

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
