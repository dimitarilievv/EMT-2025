package mk.ukim.ukim.finki.emt2025.service.application.impl;

import mk.ukim.ukim.finki.emt2025.dto.CreateAuthorDto;
import mk.ukim.ukim.finki.emt2025.dto.DisplayAuthorDto;
import mk.ukim.ukim.finki.emt2025.events.AuthorChangedEvent;
import mk.ukim.ukim.finki.emt2025.model.domain.Country;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.projections.AuthorNamesProjection;
import mk.ukim.ukim.finki.emt2025.service.application.AuthorApplicationService;
import mk.ukim.ukim.finki.emt2025.service.domain.AuthorService;
import mk.ukim.ukim.finki.emt2025.service.domain.CountryService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;

    private final CountryService countryService;
    private final ApplicationEventPublisher eventPublisher;
    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService, ApplicationEventPublisher eventPublisher) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto author) {
        Country country = countryService.findById(author.countryId()).get();
        Optional<DisplayAuthorDto> saved = authorService.save(author.toAuthor(country))
                .map(DisplayAuthorDto::from);

        saved.ifPresent(dto -> eventPublisher.publishEvent(new AuthorChangedEvent(this)));

        return saved;
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto author) {
        Country country=countryService.findById(author.countryId()).get();
        Optional<DisplayAuthorDto> updated = authorService.update(id,author.toAuthor(country))
                .map(DisplayAuthorDto::from);

        updated.ifPresent(dto -> eventPublisher.publishEvent(new AuthorChangedEvent(this)));
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        authorService.deleteById(id);
        eventPublisher.publishEvent(new AuthorChangedEvent(this));
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
            return authorService.findAll().stream()
                    .map(DisplayAuthorDto::from)
                    .collect(Collectors.toList());
    }
    @Override
    public List<AuthorByCountry> getAuthorCountByCountry() {
        return authorService.getAuthorCountByCountry();
    }
    @Override
    public List<AuthorNamesProjection> getAllHostNames() {
        return authorService.getAllHostNames();
    }
}
