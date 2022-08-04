package com.raphael.cardealership.infrastructure.controller;

import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.seller.SellerService;
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
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/sellers")
    public List<Seller> getSellers() {
        return sellerService.getSellers();
    }

    @GetMapping("/sellers/{id}")
    public Seller getSeller(@PathVariable("id") String sellerId) {
        return sellerService.getSeller(sellerId);
    }

    @PostMapping("/sellers")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping("/sellers/{id}")
    public void updateSeller(@PathVariable("id") String sellerId, @RequestBody Seller seller) {
        sellerService.updateSeller(sellerId, seller);
    }
}
