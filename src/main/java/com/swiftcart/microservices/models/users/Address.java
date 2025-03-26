package com.swiftcart.microservices.models.users;

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

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String state;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String addressLine;

    @NotNull
    @NotBlank
    private Integer zipCode;

    @NotNull
    @NotBlank
    private String label;
}
