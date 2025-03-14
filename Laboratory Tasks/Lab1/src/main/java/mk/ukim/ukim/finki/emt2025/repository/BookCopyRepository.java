package mk.ukim.ukim.finki.emt2025.repository;

import mk.ukim.ukim.finki.emt2025.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

}
