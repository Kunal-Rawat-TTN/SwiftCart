package com.swiftcart.microservices.models.users;

import com.swiftcart.microservices.models.products.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User {

    @NotNull
    @NotBlank
    @Length(min=15, max = 15)
    private String gst;

    @NotNull
    @NotBlank
    private String companyContact;@Length(min = 2, max = 15)

    @NotNull
    @NotBlank
    private String companyName;

    //Can be many to many as it will reduce the space complexity, but we will need to use join to find the required data
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Product> products;
}
