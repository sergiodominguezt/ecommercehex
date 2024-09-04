package com.example.emazon.application.services;

import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.ports.in.CreateBrandUseCase;
import com.example.emazon.domain.ports.in.ListBrandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandService implements CreateBrandUseCase, ListBrandUseCase {
    private final CreateBrandUseCase createBrandUseCase;
    private final ListBrandUseCase listBrandUseCase;
    @Override
    public Brand createBrand(Brand brand) {
        return createBrandUseCase.createBrand(brand);
    }

    @Override
    public Page<Brand> getBrandsPaginated(Pageable pageable) {
        return listBrandUseCase.getBrandsPaginated(pageable);
    }
}
