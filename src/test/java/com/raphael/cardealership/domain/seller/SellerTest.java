package com.raphael.cardealership.domain.seller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellerTest {

    @ParameterizedTest
    @EnumSource(SellerStatus.class)
    void isActive(SellerStatus status) {
        Seller seller = new Seller();
        seller.setStatus(status);

        assertEquals(status.equals(SellerStatus.ACTIVE), seller.isActive());
    }
}