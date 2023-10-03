package org.example.behavior;


import java.util.List;

public interface BookRepo {
    List<Book> findNewBooks(int days);

    Book findBookById(String number);
    void save(Book book);
    void save(BookRequest bookRequest);
}
