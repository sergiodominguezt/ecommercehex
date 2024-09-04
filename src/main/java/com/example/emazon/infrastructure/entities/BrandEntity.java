package com.example.emazon.infrastructure.entities;

import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "brand")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String brandDescription;

    public static BrandEntity fromDomainModel(Brand category) {
        return BrandEntity.builder()
                .id(category.getId())
                .brandName(category.getBrandName())
                .brandDescription(category.getBrandDescription())
                .build();
    }

    public Brand toDomainModel() {
        return Brand.builder()
                .id(id)
                .brandName(brandName)
                .brandDescription(brandDescription)
                .build();
    }

}
