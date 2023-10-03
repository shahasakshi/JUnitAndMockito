package org.example.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class bookRepoStub implements BookRepo {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1223","Mockito In Action",400, LocalDate.now());
        Book book2 = new Book("1224","JUnit 5 In Action",500, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);
        return newBooks;
    }

}
