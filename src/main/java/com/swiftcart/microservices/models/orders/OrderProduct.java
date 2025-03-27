package com.swiftcart.microservices.models.orders;

import com.swiftcart.microservices.models.products.Product;
import com.swiftcart.microservices.models.products.ProductVariation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductVariation productVariation;

    private Integer quantity;
    private Double price;

    @OneToOne(mappedBy = "orderProduct")
    private OrderStatus orderStatus;
}
