package mk.ukim.ukim.finki.emt2025.web;

import mk.ukim.ukim.finki.emt2025.model.DisplayNumBooksByAuthor;
import mk.ukim.ukim.finki.emt2025.repository.DisplayNumBooksByAuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookStatsController {
    private final DisplayNumBooksByAuthorRepository repository;

    public BookStatsController(DisplayNumBooksByAuthorRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/by-author")
    public List<DisplayNumBooksByAuthor> getBooksByAuthor() {
        return repository.findAll();
    }
}
