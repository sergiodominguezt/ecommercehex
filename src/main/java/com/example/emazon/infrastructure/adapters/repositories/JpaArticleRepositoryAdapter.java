package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.ports.out.ArticleRepository;
import com.example.emazon.infrastructure.entities.ArticleEntity;
import com.example.emazon.infrastructure.entities.BrandEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JpaArticleRepositoryAdapter implements ArticleRepository {
    private final JpaArticleRepository jpaArticleRepository;
    @Override
    public Article saveArticle(Article article) {
        return null;
    }

    @Override
    public Page<Article> findAllPaginated(Pageable pageable) {
        Page<ArticleEntity> articleEntities = jpaArticleRepository.findAll(pageable);
        return articleEntities.map(ArticleEntity::toDomainModel);
    }

    @Override
    public ArticleEntity save(ArticleEntity articleEntity) {
        return jpaArticleRepository.save(articleEntity);
    }
}
