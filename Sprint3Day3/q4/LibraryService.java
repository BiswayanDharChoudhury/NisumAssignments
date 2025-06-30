package com.nisum.NisumAssignments;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    // CRUD operations
    public Book createBook(Book book) {
        book.setId(nextId.getAndIncrement());
        books.put(book.getId(), book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (!books.containsKey(id)) throw new ResourceNotFoundException("Book not found");
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public Book getBookById(Long id) {
        Book book = books.get(id);
        if (book == null) throw new ResourceNotFoundException("Book not found");
        return book;
    }

    public void deleteBook(Long id) {
        if (!books.containsKey(id)) throw new ResourceNotFoundException("Book not found");
        books.remove(id);
    }

    // Pagination and filtering
    public List<Book> getAllBooks(int page, int size, String author, Integer publishedYear) {
        return books.values().stream()
            .filter(book -> author == null || book.getAuthor().equalsIgnoreCase(author))
            .filter(book -> publishedYear == null || book.getPublishedYear().equals(publishedYear))
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }
}
