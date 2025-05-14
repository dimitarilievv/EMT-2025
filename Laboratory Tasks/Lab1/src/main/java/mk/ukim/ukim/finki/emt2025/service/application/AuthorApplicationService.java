package mk.ukim.ukim.finki.emt2025.service.application;

import mk.ukim.ukim.finki.emt2025.dto.CreateAuthorDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayAuthorDto;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.projections.AuthorNamesProjection;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    Optional<DisplayAuthorDto> findById(Long id);
    Optional<DisplayAuthorDto> save(CreateAuthorDto author);
    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto author);
    void deleteById(Long id);
    List<DisplayAuthorDto> findAll();
    List<AuthorByCountry> getAuthorCountByCountry();
    List<AuthorNamesProjection> getAllHostNames();
}
