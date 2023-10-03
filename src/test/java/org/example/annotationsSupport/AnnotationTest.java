package org.example.annotationsSupport;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class AnnotationTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService;


    @Test
    public void demoMockWithMockito() {

      //  BookService bookService = new BookService(bookRepo);

        org.example.annotationsSupport.Book book1 = new org.example.annotationsSupport.Book("1223", "Mockito In Action", 500, LocalDate.now());
        org.example.annotationsSupport.Book book2 = new Book("1224", "JUnit 5 In Action", 400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);


        Mockito.when(bookRepo.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10,7);
        assertEquals(2,newBooksWithAppliedDiscount.size());
        assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());

        assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());

    }
}
