package mk.ukim.ukim.finki.emt2025.dto;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.model.domain.Country;

public record CreateAuthorDto(String name, String surname, Long countryId) {
    public Author toAuthor(Country country){
        return new Author(name,surname,country);
    }
}
