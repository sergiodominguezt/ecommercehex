package com.example.emazon.domain.ports.out;

import com.example.emazon.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandRepository {
    Brand saveBrand(Brand brand);
    Page<Brand> findAllPaginated(Pageable pageable);
    boolean existsByBrandName(String brandName);
}
