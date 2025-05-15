package mk.ukim.ukim.finki.emt2025.service.domain.impl;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.projections.AuthorNamesProjection;
import mk.ukim.ukim.finki.emt2025.repository.AuthorRepository;
import mk.ukim.ukim.finki.emt2025.repository.CountryRepository;
import mk.ukim.ukim.finki.emt2025.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }
    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    @Override
    public Optional<Author> save(Author author) {
        if (author.getName() != null && author.getSurname() != null && author.getCountry() != null) {
            Long countryId = author.getCountry().getId();
            return countryRepository.findById(countryId)
                    .map(country -> {
                        Author newAuthor = new Author(author.getName(), author.getSurname(), country);
                        return Optional.of(authorRepository.save(newAuthor));
                    })
                    .orElse(Optional.empty());
        }
        return Optional.empty();
    }


    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor-> {
            if (author.getName() != null) {
                existingAuthor.setName(author.getName());
            }
            if (author.getSurname() != null) {
                existingAuthor.setSurname(author.getSurname());
            }
            if (author.getCountry() != null && countryRepository.findById(author.getCountry().getId()).isPresent()) {
                existingAuthor.setCountry(countryRepository.findById(author.getCountry().getId()).get());
            }
            return authorRepository.save(existingAuthor);
        });
    }

    @Override
    public void deleteById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id " + id));
        authorRepository.delete(author);
    }

    @Override
    public List<AuthorByCountry> getAuthorCountByCountry() {
        return authorRepository.getAuthorsByCountry();
    }
    @Override
    public List<AuthorNamesProjection> getAllHostNames() {
        return authorRepository.findAllHostNames();
    }


}
