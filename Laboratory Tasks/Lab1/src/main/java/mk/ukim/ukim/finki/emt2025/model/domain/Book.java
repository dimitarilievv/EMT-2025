package mk.ukim.ukim.finki.emt2025.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    //@OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    private List<BookHistory> bookHistory;
    public Book() {
        this.bookHistory=new ArrayList<>();
    }

    public Book(String name, Category category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.bookHistory=new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public List<BookHistory> getBookHistory() {
        return bookHistory;
    }
}
