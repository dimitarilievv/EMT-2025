package mk.ukim.ukim.finki.emt2025.repository;

import mk.ukim.ukim.finki.emt2025.model.DisplayNumBooksByAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  DisplayNumBooksByAuthorRepository extends JpaRepository<DisplayNumBooksByAuthor, String> {
    List<DisplayNumBooksByAuthor> findAll();
}
