package org.example.dummy;

import org.example.fake.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepo implements BookRepo {

    //InMemory Database,HashMap,List without using actual database we can test

    Map<String, org.example.dummy.Book> bookStore = new HashMap<>();


    @Override
    public void save(org.example.dummy.Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<org.example.dummy.Book> findAll() {
        return bookStore.values();
    }
}
