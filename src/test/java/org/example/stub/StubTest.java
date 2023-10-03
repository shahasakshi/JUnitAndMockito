package org.example.stub;

import org.example.dummy.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StubTest {

    @Test
    public void demoStub(){
        BookRepo bookRepo = new bookRepoStub();
        BookService bookService = new BookService(bookRepo);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10,7);


        assertEquals(2,newBooksWithAppliedDiscount.size());
        assertEquals(360,newBooksWithAppliedDiscount.get(0).getPrice());

        assertEquals(450,newBooksWithAppliedDiscount.get(1).getPrice());

    }

    @Test
    public void demoStubWithMockito(){
        org.example.stub.BookRepo bookRepo = mock(org.example.stub.BookRepo.class);

        org.example.stub.BookService bookService = new org.example.stub.BookService(bookRepo);


        org.example.stub.Book book1 = new org.example.stub.Book("1234","Mokito in Action",250, LocalDate.now());
        org.example.stub.Book book2 = new org.example.stub.Book("1234","Mokito in Action",250, LocalDate.now());


        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);


        when(bookRepo.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10,7);

        assertEquals(2,newBooksWithAppliedDiscount.size());
        assertEquals(360,newBooksWithAppliedDiscount.get(0).getPrice());

        assertEquals(450,newBooksWithAppliedDiscount.get(1).getPrice());




    }
}
