package com.example.emazon.domain.model;

import com.example.emazon.domain.model.dto.BrandDto;
import com.example.emazon.domain.model.dto.BrandNameDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Brand {
    private Long id;
    private String brandName;
    private String brandDescription;

    public static Brand fromDTO(BrandDto brandDto) {
        return Brand.builder()
                .brandName(brandDto.getBrandName())
                .brandDescription(brandDto.getBrandDescription())
                .build();
    }

    public BrandDto toDTO() {
        return BrandDto.builder()
                .brandName(brandName)
                .brandDescription(brandDescription)
                .build();
    }

    public BrandNameDto toBrandName() {
        return BrandNameDto.builder()
                .brandName(brandName)
                .build();
    }


}
