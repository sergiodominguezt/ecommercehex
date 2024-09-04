package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListCategoryUseCase {
    List<Category> getAllCategories();
    Page<Category> getCategoriesPaginated(Pageable pageable);
}
