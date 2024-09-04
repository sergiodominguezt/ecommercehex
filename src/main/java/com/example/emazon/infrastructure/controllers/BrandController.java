package com.example.emazon.infrastructure.controllers;

import com.example.emazon.application.services.BrandService;
import com.example.emazon.domain.model.Brand;
import com.example.emazon.domain.model.Category;
import com.example.emazon.domain.model.dto.BrandDto;
import com.example.emazon.domain.model.dto.BrandNameDto;
import com.example.emazon.domain.model.dto.CategoryDto;
import com.example.emazon.domain.model.dto.ListCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    @PostMapping
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto) {
        Brand brand = Brand.fromDTO(brandDto);
        Brand createdBrand = brandService.createBrand(brand);
        BrandDto savedBrandDto = createdBrand.toDTO();
        return new ResponseEntity<>(savedBrandDto, HttpStatus.CREATED);
    }

    @GetMapping("/paginated")
    public Page<BrandNameDto> getAllBrandsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Sort sort = Sort.by("brandName");
        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Brand> brands = brandService.getBrandsPaginated(pageable);
        return brands.map(brand -> BrandNameDto.builder()
                .brandName(brand.getBrandName())
                .build());
    }
}
