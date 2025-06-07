package mk.ukim.finki.emt2025.service.domain;

import mk.ukim.finki.emt2025.model.domain.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();

    Optional<Manufacturer> findById(Long id);
    
    Optional<Manufacturer> update(Long id, Manufacturer manufacturer);

    void deleteById(Long id);

    Optional<Manufacturer> save(Manufacturer manufacturer);
}
