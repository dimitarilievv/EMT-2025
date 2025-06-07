package mk.ukim.finki.emt2025.repository;

import mk.ukim.finki.emt2025.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
