package com.example.emazon.application.services;

import com.example.emazon.application.usecases.CreateArticleUseCaseImpl;
import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.ports.in.CreateArticleUseCase;
import com.example.emazon.domain.ports.in.ListArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService implements CreateArticleUseCase, ListArticleUseCase {
    private final CreateArticleUseCase createArticleUseCase;
    private final ListArticleUseCase listArticleUseCase;

    @Override
    public Article createArticle(Article article) {
        return createArticleUseCase.createArticle(article);
    }

    @Override
    public Page<Article> getArticlesPaginated(Pageable pageable) {
        return listArticleUseCase.getArticlesPaginated(pageable);
    }
}
