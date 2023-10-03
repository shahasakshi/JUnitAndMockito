package org.example.annotationsSupport;


import java.util.List;

public interface BookRepo {
    List<Book> findNewBooks(int days);
}
