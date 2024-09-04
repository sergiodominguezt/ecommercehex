package com.example.emazon.domain.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ArticleNamesDto {
    private String articleName;
    private List<String> associatedCategories;
}
