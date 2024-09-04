package com.example.emazon.domain.model;

import com.example.emazon.domain.model.dto.CategoryDto;
import com.example.emazon.domain.model.dto.ListCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String categoryName;
    private String categoryDescription;

    public static Category fromDTO(CategoryDto categoryDTO) {
        return Category.builder()
                .categoryName(categoryDTO.getCategoryName())
                .categoryDescription(categoryDTO.getCategoryDescription())
                .build();
    }

    public CategoryDto toDTO() {
        return CategoryDto.builder()
                .categoryName(categoryName)
                .categoryDescription(categoryDescription)
                .build();
    }

    public ListCategoryDto toListCategoryDto() {
        return ListCategoryDto.builder()
                .categoryName(categoryName)
                .build();
    }


}
