package mk.ukim.ukim.finki.emt2025.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "display_num_books_by_author")
public class DisplayNumBooksByAuthor {
    @Id
    private String name;

    private String surname;

    @Column(name = "num_books")
    private int numBooks;

    public DisplayNumBooksByAuthor() {
    }

    public DisplayNumBooksByAuthor(String name, String surname, int numBooks) {
        this.name = name;
        this.surname = surname;
        this.numBooks = numBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }
}
