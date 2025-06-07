package mk.ukim.finki.emt2025.service.application.impl;

import mk.ukim.finki.emt2025.dto.CreateCategoryDto;
import mk.ukim.finki.emt2025.dto.DisplayCategoryDto;
import mk.ukim.finki.emt2025.service.application.CategoryApplicationService;
import mk.ukim.finki.emt2025.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    private final CategoryService categoryService;

    public CategoryApplicationServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<DisplayCategoryDto> findAll() {
        return DisplayCategoryDto.from(categoryService.findAll());
    }


    @Override
    public Optional<DisplayCategoryDto> findById(Long id) {
        return categoryService.findById(id).map(DisplayCategoryDto::from);
    }

    @Override
    public Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto category) {
        return categoryService.update(id, category.toCategory()).map(DisplayCategoryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        categoryService.deleteById(id);
    }

    @Override
    public Optional<DisplayCategoryDto> save(CreateCategoryDto createCategoryDto) {
        return categoryService.save(createCategoryDto.toCategory())
                              .map(DisplayCategoryDto::from);
    }
}
