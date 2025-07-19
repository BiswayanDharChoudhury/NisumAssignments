package com.example.book.service;

import com.example.book.model.Book;

public interface BookService {
    Book findById(Long id);
}
