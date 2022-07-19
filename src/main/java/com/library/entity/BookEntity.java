package com.library.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "releaseYear")
    private Long releaseYear;


    public BookEntity updateWith(BookEntity book) {
        return BookEntity.builder()
                .id(this.id)
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .releaseYear(book.getReleaseYear())
                .build();
    }

    public static BookEntity of(String title, String author, String description, Long releaseYear) {
        return BookEntity.builder()
                .title(title)
                .author(author)
                .description(description)
                .releaseYear(releaseYear)
                .build();
    }

    public boolean dataHasErrors() {
        return this.author.equals("") ||
                this.title.equals("") ||
                this.description.equals("") ||
                this.releaseYear < 0;
    }
}
