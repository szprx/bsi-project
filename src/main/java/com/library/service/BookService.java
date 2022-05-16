package com.library.service;

import com.library.dto.BookDto;
import com.library.entity.BookEntity;
import com.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDto saveBook(BookDto book) {
        return BookDto.of(bookRepository.save(BookEntity.of(book)));
    }

    public BookDto getBook(Long id) {
        return BookDto.of(bookRepository.findById(id)
                .orElseThrow());
    }

    public List<BookDto> getBooks() {
        return BookDto.of(bookRepository.findAll());
    }

    public BookDto updateBook(Long id, BookDto book) {
        return BookDto.of(bookRepository.findById(id)
                .map(oldBook -> {
                    BookEntity updatedBook = oldBook.updateWith(book);
                    return bookRepository.save(updatedBook);
                }).orElseThrow());
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
