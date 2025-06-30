package com.nisum.NisumAssignments;

import jakarta.validation.constraints.*;
import java.time.Year;

public class Book {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be 2-100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 3, max = 50, message = "Author name must be 3-50 characters")
    private String author;

    @NotNull(message = "Published year is required")
    @PastOrPresent(message = "Published year cannot be in the future")
    @Min(value = 1000, message = "Published year must be after 1000")
    private Integer publishedYear;

    // Constructors, Getters, Setters
    public Book() {}
    public Book(Long id, String title, String author, Integer publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }
    // Getters and setters for all fields
}
