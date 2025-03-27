package com.swiftcart.microservices.models.categories;

import com.swiftcart.microservices.models.products.Product;
import com.swiftcart.microservices.models.products.ProductReview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    //Didn't use many to many mapping to reduce the complexity
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products;

    //Bidirectional bcz category data must be fetched by using category reference
    @OneToMany(mappedBy = "category", orphanRemoval = true,cascade = CascadeType.REMOVE)
    private Set<CategoryMetadataFieldValues> categoryMetadataFieldValues;
}
