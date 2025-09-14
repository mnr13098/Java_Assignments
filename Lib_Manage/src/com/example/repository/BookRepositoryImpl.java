package com.example.repository;

import com.example.entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();


    public void addBook(Book book) {
        book.setId(idCounter.incrementAndGet());
        books.add(book);
    }


    public Book getBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }


    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }


    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == updatedBook.getId()) {
                books.set(i, updatedBook);
                return;
            }
        }
    }


    public void deleteBookById(long id) {
        books.removeIf(book -> book.getId() == id);
    }


    public void deleteBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}
