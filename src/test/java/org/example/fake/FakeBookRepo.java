package org.example.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepo implements BookRepo {

    //InMemory Database,HashMap,List without using actual database we can test

    Map<String,Book> bookStore = new HashMap<>();


    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
