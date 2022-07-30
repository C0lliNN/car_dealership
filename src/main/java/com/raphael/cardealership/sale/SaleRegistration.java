package com.raphael.cardealership.sale;

import lombok.Value;

@Value
public class SaleRegistration {
    String cardId;
    String sellerId;
    String customerName;
    String customerEmail;
    String customerPhone;
}
