package mk.ukim.ukim.finki.emt2025.service.domain;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.projections.AuthorNamesProjection;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    Optional<Author> save(Author author);
    Optional<Author> update(Long id, Author author);
    void deleteById(Long id);
    List<Author> findAll();
    List<AuthorByCountry> getAuthorCountByCountry();
    List<AuthorNamesProjection> getAllHostNames();
}
