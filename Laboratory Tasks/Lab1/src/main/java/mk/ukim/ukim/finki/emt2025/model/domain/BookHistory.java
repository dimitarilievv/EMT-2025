package mk.ukim.ukim.finki.emt2025.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;

@Data
@Entity
@Table(name = "book_history")
public class BookHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BookHistory() {
    }

    public BookHistory(String name, Category category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
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
}
