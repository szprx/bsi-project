package com.library.controller;

import com.library.entity.BookEntity;
import com.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/add")
    public BookEntity saveBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public BookEntity updateBook(@PathVariable long id, @RequestBody BookEntity book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }
}
