package com.example.emazon.infrastructure.config;

import com.example.emazon.application.services.ArticleService;
import com.example.emazon.application.services.BrandService;
import com.example.emazon.application.services.CategoryService;
import com.example.emazon.application.usecases.*;
import com.example.emazon.domain.ports.out.ArticleRepository;
import com.example.emazon.domain.ports.out.BrandRepository;
import com.example.emazon.domain.ports.out.CategoryRepository;
import com.example.emazon.infrastructure.adapters.repositories.JpaArticleRepository;
import com.example.emazon.infrastructure.adapters.repositories.JpaBrandRepository;
import com.example.emazon.infrastructure.adapters.repositories.JpaCategoryRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(
                new CreateCategoryUseCaseImpl(categoryRepository),
                new ListCategoryUseCaseImpl(categoryRepository)
        );
    }
    public CategoryRepository categoryRepository(JpaCategoryRepository jpaCategoryRepository){
        return (CategoryRepository) jpaCategoryRepository;
    }

    @Bean
    public BrandService brandService(BrandRepository brandRepository) {
        return new BrandService(
                new CreateBrandUseCaseImpl(brandRepository),
                new ListBrandUseCaseImpl(brandRepository)
        );
    }

    public BrandRepository brandRepository(JpaBrandRepository jpaBrandRepository){
        return (BrandRepository) jpaBrandRepository;
    }

    @Bean
    public ArticleService articleService(ArticleRepository articleRepository, CategoryRepository categoryRepository, EntityManager entityManager) {
        return new ArticleService(
                new CreateArticleUseCaseImpl(articleRepository, categoryRepository),
                new ListArticleUseCaseImpl(articleRepository, entityManager)
        );
    }

    public ArticleRepository articleRepository(JpaArticleRepository jpaArticleRepository){
        return (ArticleRepository) jpaArticleRepository;
    }
}
