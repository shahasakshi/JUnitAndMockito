package org.example.behavior.verification;


import org.example.behavior.Book;
import org.example.behavior.BookRepo;
import org.example.behavior.BookService;
import org.example.behavior.BookRequest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepo bookRepo;

    @Test
    public void testAddBook(){
       Book book = new Book(null,"Mockito is in Action",500, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepo).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",500,LocalDate.now());
        org.example.behavior.Book book = new org.example.behavior.Book(null,"Mokito is in Action",500, LocalDate.now());
        // doNothing().when(bookRepo).save(book);
       bookService.addBook(bookRequest);
       verify(bookRepo,times(0)).save(book);
    }
    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice1(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",600,LocalDate.now());
        org.example.behavior.Book book = new org.example.behavior.Book(null,"Mockito In Action",600, LocalDate.now());
        // doNothing().when(bookRepo).save(book);
        bookService.addBook(bookRequest);
        verify(bookRepo,times(1)).save(book);
    }
    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice2(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",600,LocalDate.now());
        org.example.behavior.Book book = new org.example.behavior.Book(null,"Mockito In Action",600, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepo,never()).save(book);
    }


}
