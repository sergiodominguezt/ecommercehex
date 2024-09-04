package com.example.emazon.infrastructure.controllers;

import com.example.emazon.application.services.CategoryService;
import com.example.emazon.domain.model.Category;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = Category.fromDTO(categoryDto);
        Category createdCategory = categoryService.createCategory(category);
        CategoryDto savedCategoryDto = createdCategory.toDTO();
        return new ResponseEntity<>(savedCategoryDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ListCategoryDto> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream().map(Category::toListCategoryDto).collect(Collectors.toList());
    }

    @GetMapping("/paginated")
    public Page<ListCategoryDto> getAllCategoriesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Sort sort = Sort.by("categoryName");
        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Category> categories = categoryService.getCategoriesPaginated(pageable);
        return categories.map(category -> ListCategoryDto.builder()
                .categoryName(category.getCategoryName())
                .build());
    }

}
