package mk.ukim.ukim.finki.emt2025.service.application;

import mk.ukim.ukim.finki.emt2025.dto.CreateBookDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayBookDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayBookHistoryDto;
import mk.ukim.ukim.finki.emt2025.model.DisplayNumBooksByAuthor;
import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.repository.DisplayNumBooksByAuthorRepository;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<DisplayBookDto> findAll();
    Optional<DisplayBookDto> findById(Long id);
    Optional<DisplayBookDto> save(CreateBookDto book);
    Optional<DisplayBookDto> update(Long id,CreateBookDto book);
    void deleteById(Long id);
    List<DisplayBookDto> search(String name, Long authorId, Category category);
    List<DisplayBookHistoryDto> findAllVersions(Long id);


}
