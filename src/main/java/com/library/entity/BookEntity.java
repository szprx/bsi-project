package com.library.entity;

import com.library.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "releaseYear")
    private Long releaseYear;

    public static BookEntity of(BookDto book) {
        return BookEntity.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .releaseYear(book.getReleaseYear())
                .build();
    }

    public BookEntity updateWith(BookDto book) {
        return BookEntity.builder()
                .id(this.id)
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .releaseYear(book.getReleaseYear())
                .build();
    }
}
