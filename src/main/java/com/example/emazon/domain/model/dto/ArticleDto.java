package com.example.emazon.domain.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ArticleDto {
    private String articleName;
    private String articleDescription;
    private BigDecimal quantity;
    private BigDecimal price;
    private List<String> associatedCategories;
}
