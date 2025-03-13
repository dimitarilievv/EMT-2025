package mk.ukim.ukim.finki.emt2025.service;

import mk.ukim.ukim.finki.emt2025.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
}
