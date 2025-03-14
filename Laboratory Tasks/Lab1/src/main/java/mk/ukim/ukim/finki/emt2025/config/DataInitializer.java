package mk.ukim.ukim.finki.emt2025.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.ukim.finki.emt2025.model.*;
import mk.ukim.ukim.finki.emt2025.repository.AuthorRepository;
import mk.ukim.ukim.finki.emt2025.repository.BookCopyRepository;
import mk.ukim.ukim.finki.emt2025.repository.BookRepository;
import mk.ukim.ukim.finki.emt2025.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country c1=countryRepository.save(new Country("Macedonia","Europe"));
        Country c2= countryRepository.save(new Country("Japan","Asia"));

        Author a1= authorRepository.save(new Author("Dimitar","Iliev",c1));
        Author a2=authorRepository.save(new Author("Mila","Ilieva",c2));

        bookRepository.save(new Book("Book 1", Category.CLASSICS,a1));
        bookRepository.save(new Book("Book 2", Category.BIOGRAPHY,a2));
    }

}
