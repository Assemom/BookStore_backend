package com.example.BookStore.service;

import com.example.BookStore.model.Book;
import java.util.List;

public interface BookService {
    Book addNewBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}
