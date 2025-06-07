package mk.ukim.finki.emt2025.service.application.impl;

import mk.ukim.finki.emt2025.dto.CreateManufacturerDto;
import mk.ukim.finki.emt2025.dto.DisplayManufacturerDto;
import mk.ukim.finki.emt2025.service.application.ManufacturerApplicationService;
import mk.ukim.finki.emt2025.service.domain.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerApplicationServiceImpl implements ManufacturerApplicationService {

    private final ManufacturerService manufacturerService;

    public ManufacturerApplicationServiceImpl(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<DisplayManufacturerDto> findAll() {
        return DisplayManufacturerDto.from(manufacturerService.findAll());
    }

    @Override
    public Optional<DisplayManufacturerDto> findById(Long id) {
        return manufacturerService.findById(id).map(DisplayManufacturerDto::from);
    }

    @Override
    public Optional<DisplayManufacturerDto> update(Long id, CreateManufacturerDto manufacturer) {
        return manufacturerService.update(id, manufacturer.toManufacturer())
                                  .map(DisplayManufacturerDto::from);
    }

    @Override
    public void deleteById(Long id) {
        manufacturerService.deleteById(id);
    }

    @Override
    public Optional<DisplayManufacturerDto> save(CreateManufacturerDto createManufacturerDto) {
        return manufacturerService.save(createManufacturerDto.toManufacturer())
                                  .map(DisplayManufacturerDto::from);
    }
}
