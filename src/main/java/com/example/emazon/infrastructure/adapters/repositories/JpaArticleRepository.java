package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.infrastructure.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
