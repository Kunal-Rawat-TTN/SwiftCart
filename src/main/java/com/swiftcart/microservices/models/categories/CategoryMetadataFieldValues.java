package com.swiftcart.microservices.models.categories;

import com.swiftcart.microservices.models.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMetadataFieldValues {
    @EmbeddedId
    CategoryMetadataFieldValuesId categoryMetadataFieldValuesId;

    private String values;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @MapsId("categoryMetadataFieldId")
    @JoinColumn(name = "category_metadata_field_id", nullable = false)
    private CategoryMetadataField categoryMetadataField;
}
