package mk.ukim.finki.emt2025.service.application;

import mk.ukim.finki.emt2025.dto.CreateManufacturerDto;
import mk.ukim.finki.emt2025.dto.DisplayManufacturerDto;

import java.util.List;
import java.util.Optional;

public interface ManufacturerApplicationService {

    List<DisplayManufacturerDto> findAll();

    Optional<DisplayManufacturerDto> findById(Long id);

    Optional<DisplayManufacturerDto> update(Long id, CreateManufacturerDto manufacturer);

    void deleteById(Long id);

    Optional<DisplayManufacturerDto> save(CreateManufacturerDto createManufacturerDto);
}
