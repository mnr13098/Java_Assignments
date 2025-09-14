package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.repository.BookRepositoryImpl;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepositoryImpl();
    }


    public void addBook(Book book) {
        bookRepository.addBook(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }


    public Book findBookById(long id) {
        return bookRepository.getBookById(id);
    }


    public Book findBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }


    public List<Book> listAllBooks() {
        return bookRepository.getAllBooks();
    }


    public void updateBook(Book book) {
        bookRepository.updateBook(book);
        System.out.println("Book updated successfully: " + book.getTitle());
    }


    public void updateBookTitle(long id, String newTitle) {
        Book book = bookRepository.getBookById(id);
        if (book != null) {
            book.setTitle(newTitle);
            bookRepository.updateBook(book);
            System.out.println("Book title updated.");
        } else {
            System.out.println("Book not found with id: " + id);
        }
    }


    public void updateBookPrice(long id, double newPrice) {
        Book book = bookRepository.getBookById(id);
        if (book != null) {
            book.setPrice(newPrice);
            bookRepository.updateBook(book);
            System.out.println("Book price updated.");
        } else {
            System.out.println("Book not found with id: " + id);
        }
    }


    public void updateBookQuantity(long id, int newQuantity) {
        Book book = bookRepository.getBookById(id);
        if (book != null) {
            book.setQuantity(newQuantity);
            bookRepository.updateBook(book);
            System.out.println("Book quantity updated.");
        } else {
            System.out.println("Book not found with id: " + id);
        }
    }


    public void deleteBookById(long id) {
        bookRepository.deleteBookById(id);
        System.out.println("Book with id " + id + " deleted.");
    }


    public void deleteBookByTitle(String title) {
        bookRepository.deleteBookByTitle(title);
        System.out.println("Book with title '" + title + "' deleted.");
    }
}
