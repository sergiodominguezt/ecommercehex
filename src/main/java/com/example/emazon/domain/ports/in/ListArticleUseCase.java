package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListArticleUseCase {
    Page<Article> getArticlesPaginated(Pageable pageable);
}
