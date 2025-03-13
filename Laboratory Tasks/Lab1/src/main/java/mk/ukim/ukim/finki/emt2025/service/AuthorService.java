package mk.ukim.ukim.finki.emt2025.service;

import mk.ukim.ukim.finki.emt2025.model.Author;
import mk.ukim.ukim.finki.emt2025.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    Optional<Author> save(AuthorDto author);
    Optional<Author> update(Long id, AuthorDto author);
    void deleteById(Long id);
    List<Author> findAll();
}
