package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Article;

public interface CreateArticleUseCase {
    Article createArticle(Article article);
}
