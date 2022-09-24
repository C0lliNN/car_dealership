package com.raphael.cardealership.seller;

import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.seller.SellerRepository;
import com.raphael.cardealership.domain.seller.SellerService;
import com.raphael.cardealership.domain.seller.SellerStatus;
import com.raphael.cardealership.domain.shared.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    @InjectMocks
    private SellerService sellerService;

    @Mock
    private SellerRepository repository;

    @Test
    void getSellers() {
        Seller seller1 = new Seller("id-1", "Raphael Collin", "raphael@test.com", SellerStatus.ACTIVE, null);
        Seller seller2 = new Seller("id-2", "Pedro Lourenço", "pedro@test.com", SellerStatus.ACTIVE, LocalDate.now());

        List<Seller> sellers = List.of(seller1, seller2);

        when(repository.findAll()).thenReturn(sellers);

        List<Seller> actual = sellerService.getSellers();

        assertEquals(sellers, actual);
    }

    @Test
    void getSeller() {
        when(repository.findById("id-1")).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> sellerService.getSeller("id-1"));

        Seller expected = new Seller("id-1", "Raphael Collin", "raphael@test.com", SellerStatus.ACTIVE, null);
        when(repository.findById("id-1")).thenReturn(Optional.of(expected));

        Seller actual = sellerService.getSeller("id-1");

        assertEquals(expected, actual);
    }

    @Test
    void createSeller() {
        Seller seller = new Seller(null, "Raphael Collin", "raphael@test.com", null, LocalDate.now());

        Seller actual = sellerService.createSeller(seller);

        assertEquals(SellerStatus.ACTIVE, actual.getStatus());
        assertEquals(36, actual.getId().length());
    }

    @Test
    void updateSeller() {
        Seller existing = new Seller("id-1", "Raphael Collin", "raphael@test.com", null, LocalDate.now());
        when(repository.findById("id-1")).thenReturn(Optional.of(existing));

        Seller newSeller = new Seller("id-1", "Raphael", "raphael@test.com", SellerStatus.ACTIVE, LocalDate.now());

        sellerService.updateSeller("id-1", newSeller);

//        verify(repository).save(newSeller);
    }
}