package com.example.emazon.application.usecases;

import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.ports.in.ListBrandUseCase;
import com.example.emazon.domain.ports.out.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class ListBrandUseCaseImpl implements ListBrandUseCase {
    private final BrandRepository brandRepository;
    @Override
    public Page<Brand> getBrandsPaginated(Pageable pageable) {
        return brandRepository.findAllPaginated(pageable);
    }
}
