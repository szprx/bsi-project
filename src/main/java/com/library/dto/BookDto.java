package com.library.dto;

import com.library.entity.BookEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class BookDto {
    private String title;
    private String author;
    private String description;
    private Long releaseYear;

    public static BookDto of(BookEntity book) {
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .releaseYear(book.getReleaseYear())
                .build();
    }

    public static List<BookDto> of(List<BookEntity> books) {
        return books
                .stream()
                .map(BookDto::of)
                .toList();
    }
}

