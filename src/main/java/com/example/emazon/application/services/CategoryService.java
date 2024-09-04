package com.example.emazon.application.services;

import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.model.dto.CategoryDto;
import com.example.emazon.domain.ports.in.CreateCategoryUseCase;
import com.example.emazon.domain.ports.in.ListCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService implements CreateCategoryUseCase, ListCategoryUseCase {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final ListCategoryUseCase listCategoryUseCase;

    @Override
    public Category createCategory(Category category) {
        return createCategoryUseCase.createCategory(category);
    }


    @Override
    public List<Category> getAllCategories() {
        return listCategoryUseCase.getAllCategories();
    }

    @Override
    public Page<Category> getCategoriesPaginated(Pageable pageable) {
        return listCategoryUseCase.getCategoriesPaginated(pageable);
    }
}
