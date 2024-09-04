package com.example.emazon.infrastructure.entities;

import com.example.emazon.domain.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryDescription;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<ArticleEntity> articles = new HashSet<>();

    public static CategoryEntity fromDomainModel(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .categoryDescription(category.getCategoryDescription())
                .build();
    }

    public Category toDomainModel() {
        return Category.builder()
                .id(id)
                .categoryName(categoryName)
                .categoryDescription(categoryDescription)
                .build();
    }
}
