package org.example.stub;


import java.util.Collection;
import java.util.List;

public interface BookRepo {
    List<Book> findNewBooks(int days);
}
