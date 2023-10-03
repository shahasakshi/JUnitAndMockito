package org.example.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class SpyTest {
    @Test
    public void demoMock(){
        BookRepoSpy bookRepoSpy = new BookRepoSpy();
        BookService bookService = new BookService(bookRepoSpy);

       org.example.spy.Book book1 = new org.example.spy.Book("1223","Mockito In Action",500, LocalDate.now());
        org.example.spy.Book book2 = new Book("1224","JUnit 5 In Action",400, LocalDate.now());


        bookService.addBook(book1);
        assertEquals(0,bookRepoSpy.timeCalled());
        bookService.addBook(book2);
        assertEquals(1,bookRepoSpy.timeCalled());

//        assertEquals(2,bookRepoSpy.timeCalled());
//        assertTrue(bookRepoSpy.calledWith(book2));

    }

    @Test
    public void demoSpyWithMockito(){
        org.example.spy.BookRepo bookRepoSpy = spy(BookRepo.class);
        org.example.spy.BookService bookService = new org.example.spy.BookService(bookRepoSpy);

        org.example.spy.Book book1 = new org.example.spy.Book("1223","Mockito In Action",500, LocalDate.now());
        org.example.spy.Book book2 = new org.example.spy.Book("1224","JUnit 5 In Action",400, LocalDate.now());


        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        Mockito.verify(bookRepoSpy,Mockito.times(1)).save(book2);
        Mockito.verify(bookRepoSpy,Mockito.times(0)).save(book1);

    }
}
