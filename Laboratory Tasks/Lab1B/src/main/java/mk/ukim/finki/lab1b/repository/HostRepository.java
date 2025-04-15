package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {

}