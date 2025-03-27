package com.swiftcart.microservices.models.products;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class ProductReviewId implements Serializable {
    private UUID userId;
    private UUID productId;
}
