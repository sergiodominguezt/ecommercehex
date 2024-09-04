package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.model.dto.CategoryDto;

public interface CreateCategoryUseCase {
    Category createCategory(Category category);
}
