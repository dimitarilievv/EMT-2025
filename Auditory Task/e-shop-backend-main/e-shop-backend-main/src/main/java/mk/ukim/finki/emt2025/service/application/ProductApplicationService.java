package mk.ukim.finki.emt2025.service.application;

import mk.ukim.finki.emt2025.dto.CreateProductDto;
import mk.ukim.finki.emt2025.dto.DisplayProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductApplicationService {

    Optional<DisplayProductDto> update(Long id, CreateProductDto productDto) ;

    Optional<DisplayProductDto> save(CreateProductDto productDto);

    Optional<DisplayProductDto> findById(Long id);

    List<DisplayProductDto> findAll();
    Page<DisplayProductDto> findAll(Pageable pageable);

    void deleteById(Long id);
}
