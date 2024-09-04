package com.example.emazon.domain.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDto {
    private String brandName;
    private String brandDescription;
}
