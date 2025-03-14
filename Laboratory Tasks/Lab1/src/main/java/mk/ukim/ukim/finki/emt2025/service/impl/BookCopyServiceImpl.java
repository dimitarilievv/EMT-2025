package mk.ukim.ukim.finki.emt2025.service.impl;

import mk.ukim.ukim.finki.emt2025.model.Book;
import mk.ukim.ukim.finki.emt2025.model.BookCopy;
import mk.ukim.ukim.finki.emt2025.model.Condition;
import mk.ukim.ukim.finki.emt2025.repository.BookCopyRepository;
import mk.ukim.ukim.finki.emt2025.service.BookCopyService;
import mk.ukim.ukim.finki.emt2025.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookCopyServiceImpl implements BookCopyService {
    private final BookCopyRepository bookCopyRepository;
    private final BookService bookService;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookService bookService) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookService = bookService;
    }

    @Override
    public Optional<Book> createCopy(Long id) {
        Book book=bookService.findById(id).get();
        bookCopyRepository.save(new BookCopy(book));
        return Optional.of(book);
    }

    @Override
    public Optional<BookCopy> findById(Long id) {
        return Optional.of(bookCopyRepository.findById(id).get());
    }

    @Override
    public List<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public List<BookCopy> findByBook(Long id) {
        Book book=bookService.findById(id).get();
        return bookCopyRepository.findAll()
                .stream()
                .filter(bookCopy->bookCopy.getBook().equals(book))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> rent(Long id) {
        BookCopy bookCopy=bookCopyRepository.findById(id).get();
        bookCopy.setIsRented(true);
        bookCopyRepository.save(bookCopy);
        return Optional.of(bookCopy.getBook());
    }

    @Override
    public Optional<BookCopy> returnBook(Long id) {
        BookCopy bookCopy=bookCopyRepository.findById(id).get();
        bookCopy.setIsRented(false);
        return Optional.of(bookCopy);
    }

    @Override
    public Optional<BookCopy> changeCondition(Long id, Condition condition) {
        return bookCopyRepository.findById(id)
                .map(bookCopy -> {
                    bookCopy.setCondition(condition);
                    return bookCopyRepository.save(bookCopy);
                });
    }
}
