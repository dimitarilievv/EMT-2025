package mk.ukim.finki.emt2025.repository;

import mk.ukim.finki.emt2025.model.views.ProductsPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsPerCategoryViewRepository
        extends JpaRepository<ProductsPerCategoryView, Long> {

    ProductsPerCategoryView findByCategoryId(Long categoryId);
}

