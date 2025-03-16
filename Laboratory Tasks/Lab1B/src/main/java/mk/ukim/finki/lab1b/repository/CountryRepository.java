package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

}
