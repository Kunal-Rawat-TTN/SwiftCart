package com.swiftcart.microservices.models.products;

import com.swiftcart.microservices.models.categories.Category;
import com.swiftcart.microservices.models.users.Seller;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @ColumnDefault("true")
    private Boolean isCancellable;

    @ColumnDefault("true")
    private Boolean isReturnable;

    @NotNull
    @NotBlank
    private Boolean brand;

    @ColumnDefault("true")
    private Boolean isActive;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name="seller_id")
    Seller seller;

    @ManyToOne
    @JoinColumn(name="category_id")
    Category category;

    //once reviewed then review can't be removed from history, that's why orphan removal is not true
    //Bi directional bcz product data must be fetched by using product reference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductReview> productReviews;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductVariation> productVariations;

}
