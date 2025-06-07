package mk.ukim.finki.emt2025.service.application.impl;

import mk.ukim.finki.emt2025.model.domain.Category;
import mk.ukim.finki.emt2025.model.domain.Manufacturer;
import mk.ukim.finki.emt2025.dto.CreateProductDto;
import mk.ukim.finki.emt2025.dto.DisplayProductDto;
import mk.ukim.finki.emt2025.service.application.ProductApplicationService;
import mk.ukim.finki.emt2025.service.domain.CategoryService;
import mk.ukim.finki.emt2025.service.domain.ManufacturerService;
import mk.ukim.finki.emt2025.service.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    public ProductApplicationServiceImpl(
            ProductService productService,
            ManufacturerService manufacturerService,
            CategoryService categoryService
    ) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @Override
    public Optional<DisplayProductDto> findById(Long id) {
        return productService.findById(id).map(DisplayProductDto::from);
    }

    @Override
    public List<DisplayProductDto> findAll() {
        return productService.findAll().stream().map(DisplayProductDto::from).toList();
    }

    @Override
    public Page<DisplayProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable)
                .map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto) {
        Optional<Manufacturer> manufacturer = manufacturerService.findById(createProductDto.manufacturerId());
        Optional<Category> category = categoryService.findById(createProductDto.categoryId());

        return productService.update(id,
                                     createProductDto.toProduct(
                                             category.orElse(null),
                                             manufacturer.orElse(null)
                                     )
                             )
                             .map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> save(CreateProductDto createProductDto) {
        Optional<Manufacturer> manufacturer = manufacturerService.findById(createProductDto.manufacturerId());
        Optional<Category> category = categoryService.findById(createProductDto.categoryId());

        if (manufacturer.isPresent() && category.isPresent()) {
            return productService.save(createProductDto.toProduct(category.get(), manufacturer.get()))
                                 .map(DisplayProductDto::from);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}
