package mk.ukim.ukim.finki.emt2025.service;

import mk.ukim.ukim.finki.emt2025.model.Book;
import mk.ukim.ukim.finki.emt2025.model.Category;
import mk.ukim.ukim.finki.emt2025.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto book);
    Optional<Book> update(Long id,BookDto book);
    void deleteById(Long id);
//    Optional<Book> markAsRented(Long id,BookDto book);
    List<Book> search(String name,Long authorId,Category category);
}
