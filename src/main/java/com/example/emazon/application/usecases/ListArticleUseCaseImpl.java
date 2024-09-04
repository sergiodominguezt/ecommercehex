package com.example.emazon.application.usecases;

import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.ports.in.ListArticleUseCase;
import com.example.emazon.domain.ports.out.ArticleRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@RequiredArgsConstructor
public class ListArticleUseCaseImpl implements ListArticleUseCase {
    private final ArticleRepository articleRepository;
    private final EntityManager entityManager;
    @Override
    public Page<Article> getArticlesPaginated(Pageable pageable) {
        return articleRepository.findAllPaginated(pageable);
    }

//    private long getTotalCount() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//        cq.select(cb.count(cq.from(ArticleEntity.class)));
//        return entityManager.createQuery(cq).getSingleResult();
//    }
}
