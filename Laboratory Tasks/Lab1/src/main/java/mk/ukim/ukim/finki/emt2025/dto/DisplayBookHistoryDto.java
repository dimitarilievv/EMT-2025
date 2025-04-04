package mk.ukim.ukim.finki.emt2025.dto;

import mk.ukim.ukim.finki.emt2025.model.domain.Author;
import mk.ukim.ukim.finki.emt2025.model.domain.BookHistory;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookHistoryDto(String name, Category category, Author author) {
    public static DisplayBookHistoryDto from(BookHistory history){
        return new DisplayBookHistoryDto( history.getName(), history.getCategory(), history.getAuthor() );
    }
    public List<DisplayBookHistoryDto> from(List<BookHistory> countries) {
        return countries.stream().map(DisplayBookHistoryDto::from).collect(Collectors.toList());
    }
}
