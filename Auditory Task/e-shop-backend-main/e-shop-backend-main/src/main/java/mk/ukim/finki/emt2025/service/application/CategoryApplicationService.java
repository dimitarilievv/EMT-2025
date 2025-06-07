package mk.ukim.finki.emt2025.service.application;

import mk.ukim.finki.emt2025.dto.CreateCategoryDto;
import mk.ukim.finki.emt2025.dto.DisplayCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryApplicationService {

    List<DisplayCategoryDto> findAll();

    Optional<DisplayCategoryDto> findById(Long id);

    Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto category);

    void deleteById(Long id);

    Optional<DisplayCategoryDto> save(CreateCategoryDto createCategoryDto);
}
