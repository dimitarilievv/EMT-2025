package mk.ukim.ukim.finki.emt2025.service.application.impl;

import mk.ukim.ukim.finki.emt2025.dto.*;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;
import mk.ukim.ukim.finki.emt2025.service.application.CountryApplicationService;
import mk.ukim.ukim.finki.emt2025.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto country) {
        if (country.name()!= null &&
                country.continent()!=null) {
            return countryService.save(
                    country.toCountry()).map(DisplayCountryDto::from); //todo: error may be here
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto country) {
        return countryService.update(id,country.toCountry())
                .map(DisplayCountryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream()
                .map(DisplayCountryDto::from)
                .collect(Collectors.toList());
    }
}
