package org.example.mock;

import org.example.spy.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepoMock implements BookRepo {

    int saveCalled = 0;
    org.example.mock.Book lastAddedBook = null;

    @Override
    public void save(org.example.mock.Book book) {
          saveCalled++;
          lastAddedBook = book;
    }
   public void verify(org.example.mock.Book book,int times){
        assertEquals(times,saveCalled);
        assertEquals(book,lastAddedBook);
   }


}
