package com.raphael.cardealership.seller;

import com.raphael.cardealership.domain.seller.Seller;
import com.raphael.cardealership.domain.seller.SellerStatus;
import com.raphael.cardealership.domain.shared.EntityValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    @Test
    void isActive() {
        Seller s = new Seller();

        s.setStatus(SellerStatus.ACTIVE);
        assertTrue(s.isActive());

        s.setStatus(SellerStatus.INACTIVE);
        assertFalse(s.isActive());
    }
}