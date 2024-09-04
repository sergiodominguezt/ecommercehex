package com.example.emazon.application.usecases;

import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.ports.in.ListCategoryUseCase;
import com.example.emazon.domain.ports.out.CategoryRepository;
import com.example.emazon.infrastructure.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@RequiredArgsConstructor
public class ListCategoryUseCaseImpl implements ListCategoryUseCase {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getCategoriesPaginated(Pageable pageable) {
        return categoryRepository.findAllPaginated(pageable);
    }
}
