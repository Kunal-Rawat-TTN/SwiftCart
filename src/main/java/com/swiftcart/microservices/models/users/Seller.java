package com.swiftcart.microservices.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User {
//    @OneToOne
//    Address address;

    @NotNull
    @NotBlank
    @Length(min=15, max = 15)
    private String gst;

    @NotNull
    @NotBlank
    private String companyContact;

    @NotNull
    @NotBlank
    private String companyName;
}
