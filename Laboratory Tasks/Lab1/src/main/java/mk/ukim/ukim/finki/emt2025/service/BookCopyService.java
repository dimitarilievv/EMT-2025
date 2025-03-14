package mk.ukim.ukim.finki.emt2025.service;

import mk.ukim.ukim.finki.emt2025.model.Book;
import mk.ukim.ukim.finki.emt2025.model.BookCopy;
import mk.ukim.ukim.finki.emt2025.model.Condition;

import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    Optional<Book> createCopy(Long id);
    Optional<BookCopy> findById(Long id);
    List<BookCopy> findAll();
    List<BookCopy> findByBook(Long id);
    Optional<Book> rent(Long id);
    public Optional<BookCopy> returnBook(Long id);
    public Optional<BookCopy> changeCondition(Long id, Condition condition);
}
