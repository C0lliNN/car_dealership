package com.raphael.cardealership.controller;

import com.raphael.cardealership.sale.Sale;
import com.raphael.cardealership.sale.SaleRegistration;
import com.raphael.cardealership.sale.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/sales")
    public List<Sale> getSales() {
        return saleService.getSales();
    }

    @GetMapping("/sales/{id}")
    public Sale getSale(@PathVariable("id") String saleId) {
        return saleService.getSale(saleId);
    }

    @PostMapping("/sales")
    public Sale registerSale(@RequestBody @Validated SaleRegistration saleRegistration) {
        return saleService.registerNewSale(saleRegistration);
    }
}
