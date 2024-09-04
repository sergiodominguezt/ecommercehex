package com.example.emazon.application.usecases;

import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.ports.in.CreateArticleUseCase;
import com.example.emazon.domain.ports.out.ArticleRepository;
import com.example.emazon.domain.ports.out.CategoryRepository;
import com.example.emazon.infrastructure.entities.ArticleEntity;
import com.example.emazon.infrastructure.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CreateArticleUseCaseImpl implements CreateArticleUseCase {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Article createArticle(Article article) {
        List<String> categoryNames = article.getAssociatedCategories();
        if (categoryNames == null || categoryNames.isEmpty()) {
            throw new IllegalArgumentException("Al menos una categoria debe estar asociada a este articulo");
        }
        if (categoryNames.size() > 3) {
            throw new IllegalArgumentException("Un articulo no puede tener mas de 3 categorias asociadas");
        }
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (String categoryName : categoryNames) {
            CategoryEntity categoryEntity = categoryRepository.findByCategoryName(categoryName)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            if (!categoryEntities.add(categoryEntity)) {
                throw new IllegalArgumentException("Duplicate categories are not allowed");
            }
        }
        ArticleEntity articleEntity = ArticleEntity.fromDomainModel(article, categoryEntities);
        ArticleEntity savedArticleEntity = articleRepository.save(articleEntity);
        return savedArticleEntity.toDomainModel();
    }
}
