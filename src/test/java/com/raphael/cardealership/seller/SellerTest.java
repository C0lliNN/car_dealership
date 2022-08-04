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

    @Test
    void validate() {
        Seller s = new Seller();

        assertThrows(EntityValidationException.class, s::validate);
        s.setName("Raphael Collin");

        assertThrows(EntityValidationException.class, s::validate);
        s.setEmail("raphael@test");

        assertThrows(EntityValidationException.class, s::validate);
        s.setEmail("raphael@test.com");

        assertThrows(EntityValidationException.class, s::validate);
        s.setStatus(SellerStatus.ACTIVE);

        assertThrows(EntityValidationException.class, s::validate);
        s.setJoinDate(LocalDate.of(2021, 5, 5));

        assertThrows(EntityValidationException.class, s::validate);
        s.setJoinDate(LocalDate.of(2022, 5, 5));

        assertDoesNotThrow(s::validate);
    }
}