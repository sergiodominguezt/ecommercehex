package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListBrandUseCase {
    Page<Brand> getBrandsPaginated(Pageable pageable);
}
