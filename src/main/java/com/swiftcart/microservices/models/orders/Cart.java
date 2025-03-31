package com.swiftcart.microservices.models.orders;

import com.swiftcart.microservices.models.products.ProductVariation;
import com.swiftcart.microservices.models.users.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @EmbeddedId
    private CartId id;

    @ManyToOne
    @MapsId("customerUserId")
    private Customer customer;

    @ManyToOne
    @MapsId("productVariationId")
    private ProductVariation productVariation;

    private Integer quantity;
    private Boolean isWishlistItem;
}
