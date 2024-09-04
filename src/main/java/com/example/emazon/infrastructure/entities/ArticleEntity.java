package com.example.emazon.infrastructure.entities;

import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String articleName;
    private String articleDescription;
    private BigDecimal quantity;
    private BigDecimal price;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories = new ArrayList<>();

    public static ArticleEntity fromDomainModel(Article article, List<CategoryEntity> categoryEntities) {
        return ArticleEntity.builder()
                .id(article.getId())
                .articleName(article.getArticleName())
                .articleDescription(article.getArticleDescription())
                .quantity(article.getQuantity())
                .price(article.getPrice())
                .categories(categoryEntities)
                .build();
    }

    public Article toDomainModel() {
        List<String> categoryNames = categories.stream().map(CategoryEntity::getCategoryName)
                .collect(Collectors.toList());
        return Article.builder()
                .id(id)
                .articleName(articleName)
                .articleDescription(articleDescription)
                .quantity(quantity)
                .price(price)
                .associatedCategories(categoryNames)
                .build();
    }
}
