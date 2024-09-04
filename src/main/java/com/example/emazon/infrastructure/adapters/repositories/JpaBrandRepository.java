package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.infrastructure.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByBrandName(String brandName);
}
