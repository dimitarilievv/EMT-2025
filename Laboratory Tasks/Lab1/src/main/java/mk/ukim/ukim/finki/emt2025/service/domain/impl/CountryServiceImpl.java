package mk.ukim.ukim.finki.emt2025.service.domain.impl;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.domain.BookHistory;
import mk.ukim.ukim.finki.emt2025.model.domain.Country;
import mk.ukim.ukim.finki.emt2025.repository.CountryRepository;
import mk.ukim.ukim.finki.emt2025.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(Country country) {
        if (country.getName()!= null &&
                country.getContinent()!=null) {

            Country newCountry= new Country(
                    country.getName(),
                    country.getContinent()
            );

            return Optional.of(countryRepository.save(newCountry));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id).map(existingCountry-> {
            if (country.getName() != null) {
                existingCountry.setName(country.getName());
            }
            if (country.getContinent() != null) {
                existingCountry.setContinent(country.getContinent());
            }
            return countryRepository.save(existingCountry);
        });
    }

    @Override
    public void deleteById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id " + id));
        countryRepository.delete(country);
    }
}
