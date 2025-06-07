package mk.ukim.finki.emt2025.dto;

import mk.ukim.finki.emt2025.model.domain.Category;

public record CreateCategoryDto(String name, String description) {

    public Category toCategory() {
        return new Category(name, description);
    }
}