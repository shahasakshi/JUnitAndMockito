package org.example.stubbing;


import java.util.List;

public interface BookRepo {
    List<Book> findNewBooks(int days);

    Book findBookById(String number);

    void save(Book book);
}
