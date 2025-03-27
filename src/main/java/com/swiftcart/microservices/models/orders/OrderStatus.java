package com.swiftcart.microservices.models.orders;

import com.swiftcart.microservices.customEnum.CustomOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    @Id
    private UUID id;

    @OneToOne
    @MapsId("id")
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @Enumerated(EnumType.STRING)
    private CustomOrderStatus fromStatus;

    @Enumerated(EnumType.STRING)
    private CustomOrderStatus toStatus;

    private String transitionNotesComment;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime transitionDate;
}
