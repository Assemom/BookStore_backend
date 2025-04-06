package com.example.BookStore.service;

import com.example.BookStore.exception.BookNotFoundException;
import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> {
                    return new BookNotFoundException("Book not found with id: " + id);
                });
    }
    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id); // This will throw BookNotFoundException if book doesn't exist

        // Update the book properties
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishedDate(bookDetails.getPublishedDate());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
