package mk.ukim.ukim.finki.emt2025.model.dto;

import lombok.Data;
import mk.ukim.ukim.finki.emt2025.model.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }

    public BookDto() {
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public Long getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
