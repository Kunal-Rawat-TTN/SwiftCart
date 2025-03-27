package com.swiftcart.microservices.models.categories;

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
public class CategoryMetadataFieldValuesId implements Serializable {
    private UUID categoryId;
    private Long categoryMetadataFieldId;
}
