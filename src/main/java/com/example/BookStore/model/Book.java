package com.example.BookStore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "books") //Convention: use plural form for table names
@Data //Lombok annotation to generate getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required") //Only applicable to String fields
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    @Column(nullable = false,length = 100)
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")
    @Column(nullable = false,length = 100)
    private String author;

    @NotNull(message = "Published date is required") //checks if the value is not null
    @Past(message = "Published date must be in the past")
    @Column(name = "published_date",nullable = false)
    private LocalDate publishedDate;

    // Custom constructor for creating new books (without id)
    public Book(String title, String author, LocalDate publishedDate) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }
}
