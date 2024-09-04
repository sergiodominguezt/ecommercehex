package com.example.emazon.domain.ports.out;

import com.example.emazon.domain.model.Category;
import com.example.emazon.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category saveCategory(Category category);
    List<Category> findAll();
    boolean existsByCategoryName(String categoryName);
    Page<Category> findAllPaginated(Pageable pageable);
    Optional<CategoryEntity> findByCategoryName(String categoryName);

}
