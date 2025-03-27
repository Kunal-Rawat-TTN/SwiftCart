package com.swiftcart.microservices.models.products;

import com.swiftcart.microservices.models.orders.OrderProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double price;
    private Integer quantity;
//    private JSON
    private String primaryImageName;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @OneToMany(mappedBy = "productVariation")
    Set<OrderProduct> orderProducts;
}
