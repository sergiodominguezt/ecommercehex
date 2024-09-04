package com.example.emazon.application.usecases;

import com.example.emazon.domain.exception.BadRequestException;
import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.ports.in.CreateBrandUseCase;
import com.example.emazon.domain.ports.out.BrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateBrandUseCaseImpl implements CreateBrandUseCase {
    private static final String BRAND_ALREADY_EXIST = "Marca ya existente: ";
    private static final String INVALID_BRAND_DESCRIPTION = "Descripcion de marca es obligatoria";
    private final BrandRepository brandRepository;
    @Override
    public Brand createBrand(Brand brand) {
        validateBrandName(brand.getBrandName());
        validateBrandDescription(brand.getBrandDescription());
        return brandRepository.saveBrand(brand);
    }

    public void validateBrandName(String brandName) {
        if(brandRepository.existsByBrandName(brandName)) {
            throw new BadRequestException(BRAND_ALREADY_EXIST + brandName);
        }
    }

    public void validateBrandDescription(String brandDescription) {
        if (brandDescription == null || brandDescription.isEmpty()) {
            throw new BadRequestException(INVALID_BRAND_DESCRIPTION);
        }
    }
}
