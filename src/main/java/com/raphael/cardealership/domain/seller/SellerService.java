package com.raphael.cardealership.domain.seller;

import com.raphael.cardealership.domain.shared.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SellerService {
    private final SellerRepository repository;

    public List<Seller> getSellers() {
        return repository.findAll();
    }

    public Seller getSeller(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller with id '%s' was not found.", id));
    }

    public Seller createSeller(Seller seller) {
        seller.setId(UUID.randomUUID().toString());
        seller.setStatus(SellerStatus.ACTIVE);

        repository.save(seller);
        return seller;
    }

    public void updateSeller(String id, Seller seller) {
        Seller existingSeller = getSeller(id);

        existingSeller.setName(seller.getName());
        existingSeller.setEmail(seller.getEmail());
        existingSeller.setStatus(seller.getStatus());
        existingSeller.setJoinDate(seller.getJoinDate());

        repository.save(existingSeller);
    }
}
