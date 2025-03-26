package com.swiftcart.microservices.models.orders;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amountPaid;
    private LocalDateTime dateCreated;
    private String paymentMethod;
    private String customerAddressCity;

    @NotNull
    @NotBlank
    private String customerAddressState;

    @NotNull
    @NotBlank
    private String customerAddressCountry;

    @NotNull
    @NotBlank
    private String customerAddressAddressLine;

    @NotNull
    @NotBlank
    private Integer customerAddressZipCode;

    @NotNull
    @NotBlank
    private String customerAddressLabel;


}
