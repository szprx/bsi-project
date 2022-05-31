package com.library.service;

import com.library.entity.BookEntity;
import com.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookEntity saveBook(BookEntity book) {
        if (book.dataHasErrors()) {
            return null;
        }
        return bookRepository.save(book);
    }

    public BookEntity getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }

    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    public BookEntity updateBook(Long id, BookEntity book) {
        if (book.dataHasErrors()) {
            return null;
        }
        return bookRepository.findById(id)
                .map(oldBook -> {
                    BookEntity updatedBook = oldBook.updateWith(book);
                    return bookRepository.save(updatedBook);
                }).orElseThrow();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
