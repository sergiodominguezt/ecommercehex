package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.ports.out.CategoryRepository;
import com.example.emazon.infrastructure.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JpaCategoryRepositoryAdapter implements CategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.fromDomainModel(category);
        CategoryEntity savedCategoryEntity = jpaCategoryRepository.save(categoryEntity);
        return savedCategoryEntity.toDomainModel();
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = jpaCategoryRepository.findAll();
        return categoryEntities.stream()
                .map(CategoryEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return jpaCategoryRepository.existsByCategoryName(categoryName);
    }

    @Override
    public Page<Category> findAllPaginated(Pageable pageable) {
        Page<CategoryEntity> categoryEntities = jpaCategoryRepository.findAll(pageable);
        return categoryEntities.map(CategoryEntity::toDomainModel);
    }

    @Override
    public Optional<CategoryEntity> findByCategoryName(String categoryName) {
        return jpaCategoryRepository.findByCategoryName(categoryName);
    }


}
