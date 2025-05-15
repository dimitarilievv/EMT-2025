package mk.ukim.ukim.finki.emt2025.service.application;

import mk.ukim.ukim.finki.emt2025.dto.CreateAuthorDto;
import mk.ukim.ukim.finki.emt2025.dto.CreateCountryDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayAuthorDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CreateCountryDto country);
    Optional<DisplayCountryDto> update(Long id, CreateCountryDto country);
    void deleteById(Long id);
    List<DisplayCountryDto> findAll();
}
