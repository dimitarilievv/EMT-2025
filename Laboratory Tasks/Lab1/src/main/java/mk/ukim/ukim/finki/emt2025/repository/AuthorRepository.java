package mk.ukim.ukim.finki.emt2025.repository;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.projections.AuthorByCountry;
import mk.ukim.ukim.finki.emt2025.projections.AuthorNamesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query(value = "SELECT country.name AS country, COUNT(author.id) AS authorCount " +
            "FROM author " +
            "JOIN country ON author.country_id = country.id " +
            "GROUP BY country.name",
            nativeQuery = true)
    List<AuthorByCountry> getAuthorsByCountry();

    @Query("SELECT a.name AS firstName, a.surname AS lastName FROM Author a")
    List<AuthorNamesProjection> findAllHostNames();
}
