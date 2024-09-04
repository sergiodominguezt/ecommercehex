package com.example.emazon.domain.ports.in;

import com.example.emazon.domain.model.Brand;

public interface CreateBrandUseCase {
    Brand createBrand(Brand brand);
}
