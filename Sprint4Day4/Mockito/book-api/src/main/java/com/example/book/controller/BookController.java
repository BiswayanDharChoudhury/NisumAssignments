package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.BookService;
import com.example.book.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            throw new BookNotFoundException(id);
        }
        return ResponseEntity.ok(book);
    }
}
