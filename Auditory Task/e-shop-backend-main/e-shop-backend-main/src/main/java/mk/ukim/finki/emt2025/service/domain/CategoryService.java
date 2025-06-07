package mk.ukim.finki.emt2025.service.domain;

import mk.ukim.finki.emt2025.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Optional<Category> update(Long id, Category category);

    void deleteById(Long id);

    Optional<Category> save(Category category);
}
