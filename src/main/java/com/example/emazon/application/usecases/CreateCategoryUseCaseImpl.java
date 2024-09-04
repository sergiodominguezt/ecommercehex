package com.example.emazon.application.usecases;

import com.example.emazon.domain.exception.BadRequestException;
import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.ports.in.CreateCategoryUseCase;
import com.example.emazon.domain.ports.out.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private static final String CATEGORY_ALREADY_EXIST = "Categoria ya existente: ";
    private static final String INVALID_CATEGORY_DESCRIPTION = "Descripcion de categoria es obligatoria";
    private final CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        validateCategoryName(category.getCategoryName());
        validateCategoryDescription(category.getCategoryDescription());
            return categoryRepository.saveCategory(category);
    }

    public void validateCategoryName(String categoryName) {
        if(categoryRepository.existsByCategoryName(categoryName)) {
            throw new BadRequestException(CATEGORY_ALREADY_EXIST + categoryName);
        }
    }

    public void validateCategoryDescription(String categoryDescription) {
        if (categoryDescription == null || categoryDescription.isEmpty()) {
            throw new BadRequestException(INVALID_CATEGORY_DESCRIPTION);
        }
    }
}
