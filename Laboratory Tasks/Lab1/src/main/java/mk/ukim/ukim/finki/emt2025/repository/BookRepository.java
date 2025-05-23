package mk.ukim.ukim.finki.emt2025.repository;

import mk.ukim.ukim.finki.emt2025.model.DisplayNumBooksByAuthor;
import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByNameContainingIgnoreCase(String name);
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByCategory(Category category);
    @Query(value = "SELECT * FROM books_by_author_mv", nativeQuery = true)
    List<DisplayNumBooksByAuthor> findAllFromMaterializedView();
}
