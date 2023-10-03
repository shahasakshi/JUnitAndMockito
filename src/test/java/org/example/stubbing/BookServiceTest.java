package org.example.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepo bookRepo;

    @Test
    public void testCalculateTotalCostOfBooks(){
        List<String> booksIds = new ArrayList<>();
        booksIds.add("1234");
        booksIds.add("1235");

        Book book1 = new Book("1234","Mokito is in Action",500, LocalDate.now());
        Book book2 = new Book("1235","JUnit is in Action",400, LocalDate.now());
//when and thenreturn
        when(bookRepo.findBookById("1234")).thenReturn(book1);
        when(bookRepo.findBookById("1235")).thenReturn(book2);

//calling same method twice then
        when(bookRepo.findBookById("1234")).thenReturn(book2,book2);



//do and when
//        Mockito.doReturn(book1).when(bookRepo).findBookById("1234");
//        Mockito.doReturn(book2).when(bookRepo).findBookById("1235");

        int actualCost = bookService.calculateTotalCost(booksIds);
        assertEquals(800,actualCost);



    }
    @Test
    public void testSaveBook(){
        Book book1 = new Book(null,"Mokito is in Action",500, LocalDate.now());
        //doNothing --->when save method called then donNothing--used to stub out void method
        doNothing().when(bookRepo).save(book1);//==internally works equlas method
        bookService.addBook(book1);

    }

    @Test
    public void testSaveBookWithBookRequest(){
      BookRequest bookRequest = new BookRequest("Mockito In Action",500,LocalDate.now());
      Book book = new Book(null,"Mokito is in Action",500, LocalDate.now());
       doNothing().when(bookRepo).save(book);
        bookService.addBook(bookRequest);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",500,LocalDate.now());
        Book book = new Book(null,"Mokito is in Action",500, LocalDate.now());
       // doNothing().when(bookRepo).save(book);
        bookService.addBook(bookRequest);
    }
}
