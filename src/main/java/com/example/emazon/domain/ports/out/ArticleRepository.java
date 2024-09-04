package com.example.emazon.domain.ports.out;

import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.model.Brand;
import com.example.emazon.infrastructure.entities.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepository {
    Article saveArticle(Article article);
    Page<Article> findAllPaginated(Pageable pageable);
    ArticleEntity save(ArticleEntity articleEntity);
}
