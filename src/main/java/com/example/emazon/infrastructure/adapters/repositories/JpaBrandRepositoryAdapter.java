package com.example.emazon.infrastructure.adapters.repositories;

import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.ports.out.BrandRepository;
import com.example.emazon.infrastructure.entities.BrandEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class JpaBrandRepositoryAdapter implements BrandRepository {
    private final JpaBrandRepository jpaBrandRepository;
    @Override
    public Brand saveBrand(Brand brand) {
        BrandEntity brandEntity = BrandEntity.fromDomainModel(brand);
        BrandEntity savedBrandEntity = jpaBrandRepository.save(brandEntity);
        return savedBrandEntity.toDomainModel();
    }

    @Override
    public Page<Brand> findAllPaginated(Pageable pageable) {
        Page<BrandEntity> brandEntities = jpaBrandRepository.findAll(pageable);
        return brandEntities.map(BrandEntity::toDomainModel);
    }

    @Override
    public boolean existsByBrandName(String brandName) {
        return jpaBrandRepository.existsByBrandName(brandName);
    }
}
