package org.example.dummy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class DummyTest {
    @Test
    public void testDummy(){

        BookRepo bookRepo =  new FakeBookRepo();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepo,emailService);

        bookService.addBook(new Book("1234","Mokito is In Action",180, LocalDate.now()));
        bookService.addBook(new Book("1238","Mokito is In Action",190, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());


    }
//using Mockito
    @Test
    public void demoDummywithMocito(){

    org.example.dummy.BookRepo bookRepo = mock(org.example.dummy.BookRepo.class);
    EmailService emailService = mock(EmailService.class);
        org.example.dummy.BookService bookService = new org.example.dummy.BookService(bookRepo,emailService);

        org.example.dummy.Book book1 = new org.example.dummy.Book("1234","Mokito in Action",250, LocalDate.now());
        org.example.dummy.Book book2 = new org.example.dummy.Book("1234","Mokito in Action",250, LocalDate.now());

        Collection<org.example.dummy.Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        //telling mockito-->when findall method will called on u so instead of going to external db just return us books
        Mockito.when(bookRepo.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
