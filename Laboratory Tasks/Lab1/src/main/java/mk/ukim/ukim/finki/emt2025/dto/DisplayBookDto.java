package mk.ukim.ukim.finki.emt2025.dto;

import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(Long id, String name, Category category, DisplayAuthorDto author) {
    public static DisplayBookDto from(Book book){
        return new DisplayBookDto(book.getId(),book.getName(),book.getCategory(),DisplayAuthorDto.from(book.getAuthor()));
    }

    public static List<DisplayBookDto> from(List<Book> books){
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }
}
