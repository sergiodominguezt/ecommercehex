package com.example.emazon.domain.model;

import com.example.emazon.domain.model.dto.ArticleDto;
import com.example.emazon.domain.model.dto.ArticleNamesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private String articleName;
    private String articleDescription;
    private BigDecimal quantity;
    private BigDecimal price;
    private List<String> associatedCategories;


    public ArticleDto toDTO() {
        return ArticleDto.builder()
                .articleName(articleName)
                .articleDescription(articleDescription)
                .quantity(quantity)
                .price(price)
                .associatedCategories(associatedCategories)
                .build();
    }

    public static Article fromDTO(ArticleDto articleDto) {
        return Article.builder()
                .articleName(articleDto.getArticleName())
                .articleDescription(articleDto.getArticleDescription())
                .quantity(articleDto.getQuantity())
                .price(articleDto.getPrice())
                .associatedCategories(articleDto.getAssociatedCategories())
                .build();
    }
    public ArticleNamesDto toArticleName() {
        return ArticleNamesDto.builder()
                .articleName(articleName)
                .associatedCategories(associatedCategories)
                .build();
    }
}
