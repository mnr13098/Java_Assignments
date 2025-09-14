package com.example.service;

import com.example.entity.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book findBookById(long id);
    Book findBookByTitle(String title);
    List<Book> listAllBooks();
    void updateBook(Book book);
    void updateBookTitle(long id, String newTitle);
    void updateBookPrice(long id, double newPrice);
    void updateBookQuantity(long id, int newQuantity);
    void deleteBookById(long id);
    void deleteBookByTitle(String title);
}
