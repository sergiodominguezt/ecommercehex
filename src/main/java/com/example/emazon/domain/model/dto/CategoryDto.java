package com.example.emazon.domain.model.dto;

import com.example.emazon.infrastructure.entities.CategoryEntity;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class CategoryDto {
    private String categoryName;
    private String categoryDescription;
}
