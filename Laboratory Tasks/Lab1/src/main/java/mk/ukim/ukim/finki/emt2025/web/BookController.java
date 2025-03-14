package mk.ukim.ukim.finki.emt2025.web;

import mk.ukim.ukim.finki.emt2025.model.Book;
import mk.ukim.ukim.finki.emt2025.model.BookCopy;
import mk.ukim.ukim.finki.emt2025.model.Category;
import mk.ukim.ukim.finki.emt2025.model.Condition;
import mk.ukim.ukim.finki.emt2025.model.dto.BookDto;
import mk.ukim.ukim.finki.emt2025.service.BookCopyService;
import mk.ukim.ukim.finki.emt2025.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookCopyService bookCopyService;

    public BookController(BookService bookService, BookCopyService bookCopyService) {
        this.bookService = bookService;
        this.bookCopyService = bookCopyService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book) {
        return bookService.save(book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto book) {
        return bookService.update(id, book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Book> rent(@PathVariable Long id){
        return bookCopyService.rent(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/createCopy/{id}")
    public ResponseEntity<Book> createCopy(@PathVariable Long id) {
        return bookCopyService.createCopy(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/bookCopies/{id}")
    public List<BookCopy> findAllCopies(@PathVariable Long id) {
        return this.bookCopyService.findByBook(id);
    }
    @PatchMapping ("/bookCopies/changeCondition/{id}")
    public ResponseEntity<BookCopy> changeCondition(@PathVariable Long id,@RequestParam Condition condition) {
        return this.bookCopyService.changeCondition(id,condition)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Category category
    ) {
        return bookService.search(name, authorId, category);
    }

}
