package org.example.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class FakeTest {

    @Test
    public void  testFake(){
        BookRepo bookRepo = new FakeBookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.addBook(new Book("1234","Mokito in Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","JUnit 5 in Action",250, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }

    @Test
    public void testFakeWithMockito(){
        BookRepo bookRepo = mock(BookRepo.class);
        BookService bookService = new BookService(bookRepo);

        Book book1 = new Book("1234","Mokito in Action",250, LocalDate.now());
        Book book2 = new Book("1234","Mokito in Action",250, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        //telling mockito-->when findall method will called on u so instead of going to external db just return us books
        Mockito.when(bookRepo.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
