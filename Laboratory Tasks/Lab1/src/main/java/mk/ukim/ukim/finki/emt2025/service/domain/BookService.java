package mk.ukim.ukim.finki.emt2025.service.domain;

import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.domain.BookHistory;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(Book book);
    Optional<Book> update(Long id,Book book);
    void deleteById(Long id);
//    Optional<Book> markAsRented(Long id,BookDto book);
    List<Book> search(String name,Long authorId,Category category);
    List<BookHistory> findAllVersions(Long id);

}
