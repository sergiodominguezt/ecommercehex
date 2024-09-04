package com.example.emazon.infrastructure.controllers;

import com.example.emazon.application.services.ArticleService;
import com.example.emazon.domain.model.Article;
import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.model.dto.ArticleDto;
import com.example.emazon.domain.model.dto.ArticleNamesDto;
import com.example.emazon.domain.model.dto.BrandNameDto;
import com.example.emazon.domain.model.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public ResponseEntity<ArticleDto> createCategory(@RequestBody ArticleDto articleDto) {
        Article article = Article.fromDTO(articleDto);
        Article createdArticle = articleService.createArticle(article);
        ArticleDto savedArticleDto = createdArticle.toDTO();
        return new ResponseEntity<>(savedArticleDto, HttpStatus.CREATED);
    }

    @GetMapping("/paginated")
    public Page<ArticleNamesDto> getAllArticlesPaginatedgetAllArticlesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "articleName") String sortBy
    ) {
        Sort sort = Sort.by(Sort.Order.by(sortBy));
        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Article> articles = articleService.getArticlesPaginated(pageable);
        return articles.map(article -> ArticleNamesDto.builder()
                .articleName(article.getArticleName())
                .associatedCategories(article.getAssociatedCategories())
                .build());
    }
}
