package com.swiftcart.microservices.models.orders;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CartId {
    private UUID customerUserId;
    private UUID productVariationId;
}
