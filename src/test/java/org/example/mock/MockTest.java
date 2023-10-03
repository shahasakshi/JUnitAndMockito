package org.example.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockTest {
    @Test
    public void demoMock(){
       BookRepoMock bookRepoMock = new BookRepoMock();
        BookService bookService = new BookService(bookRepoMock);

       org.example.mock.Book book1 = new org.example.mock.Book("1223","Mockito In Action",500, LocalDate.now());
        org.example.mock.Book book2 = new Book("1224","JUnit 5 In Action",400, LocalDate.now());


        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        bookRepoMock.verify(book2,1); //no of times save calles

    }

    @Test
    public void demoMockWithMockito(){
        BookRepo bookRepoMock = Mockito.mock(BookRepo.class);
        BookService bookService = new BookService(bookRepoMock);

        org.example.mock.Book book1 = new org.example.mock.Book("1223","Mockito In Action",500, LocalDate.now());
        org.example.mock.Book book2 = new Book("1224","JUnit 5 In Action",400, LocalDate.now());


        bookService.addBook(book1); //return
        bookService.addBook(book2); //save will be called

        Mockito.verify(bookRepoMock,Mockito.times(1)).save(book2);
       Mockito.verify(bookRepoMock,Mockito.times(0)).save(book1);

    }


}
