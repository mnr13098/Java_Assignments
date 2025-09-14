package com.example.repository;

import com.example.entity.Book;
import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    Book getBookById(long id);
    Book getBookByTitle(String title);
    List<Book> getAllBooks();
    void updateBook(Book book);
    void deleteBookById(long id);
    void deleteBookByTitle(String title);
}
