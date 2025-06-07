package mk.ukim.finki.emt2025.service.domain.impl;

import mk.ukim.finki.emt2025.model.domain.Manufacturer;
import mk.ukim.finki.emt2025.repository.ManufacturerRepository;
import mk.ukim.finki.emt2025.service.domain.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> update(Long id, Manufacturer manufacturer) {
        return manufacturerRepository.findById(id).map(existingManufacturer -> {
            if (manufacturer.getName() != null) {
                existingManufacturer.setName(manufacturer.getName());
            }
            if (manufacturer.getAddress() != null) {
                existingManufacturer.setAddress(manufacturer.getAddress());
            }
            return manufacturerRepository.save(existingManufacturer);
        });
    }

    @Override
    public void deleteById(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Optional<Manufacturer> save(Manufacturer manufacturer) {
        return Optional.of(manufacturerRepository.save(manufacturer));
    }
}
