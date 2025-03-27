package com.swiftcart.microservices.models.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMetadataField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //Bidirectional bcz categoryMetadataField data must be fetched by using categoryMetadataField reference
    //cascade remove bcz categoryMetadataField data must not be in mapping table if metadata doesn't exist
    @OneToMany(mappedBy = "categoryMetadataField",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<CategoryMetadataFieldValues> categoryMetadataFieldValues;
}
