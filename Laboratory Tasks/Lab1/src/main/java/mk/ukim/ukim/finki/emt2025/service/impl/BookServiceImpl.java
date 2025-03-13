package mk.ukim.ukim.finki.emt2025.service.impl;

import mk.ukim.ukim.finki.emt2025.model.Author;
import mk.ukim.ukim.finki.emt2025.model.Book;
import mk.ukim.ukim.finki.emt2025.model.Category;
import mk.ukim.ukim.finki.emt2025.model.dto.BookDto;
import mk.ukim.ukim.finki.emt2025.repository.BookRepository;
import mk.ukim.ukim.finki.emt2025.service.AuthorService;
import mk.ukim.ukim.finki.emt2025.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto book) {
        if (book.getName()!= null &&
                authorService.findById(book.getAuthor()).isPresent()
                && book.getCategory()!=null &&
                book.getAvailableCopies() != null
        ) {
            return Optional.of(
                    bookRepository.save(
                            new Book(
                                    book.getName(),
                                    book.getCategory(),
                                    authorService.findById(book.getAuthor()).get(),
                                    book.getAvailableCopies()
                                    )));
        }
        return Optional.empty();

    }

    @Override
    public Optional<Book> update(Long id, BookDto book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if (book.getName() != null) {
                        existingBook.setName(book.getName());
                    }
                    if (book.getCategory() != null) {
                        existingBook.setCategory(book.getCategory());
                    }
                    if (book.getAvailableCopies() != null) {
                        existingBook.setAvailableCopies(book.getAvailableCopies());
                    }
                    if (book.getAuthor() != null && authorService.findById(book.getAuthor()).isPresent()) {
                        existingBook.setAuthor(authorService.findById(book.getAuthor()).get());
                    }
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsRented(Long id,BookDto book) {
        return bookRepository.findById(id)
                .map(existingBook ->{
                    if(book.getAvailableCopies()>0){
                        existingBook.setAvailableCopies(existingBook.getAvailableCopies()-1);
                    }
                    return bookRepository.save(existingBook);
                });
    }




}
