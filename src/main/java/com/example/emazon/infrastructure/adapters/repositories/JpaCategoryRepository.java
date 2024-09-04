package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.domain.ports.out.CategoryRepository;
import com.example.emazon.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByCategoryName(String categoryName);
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
