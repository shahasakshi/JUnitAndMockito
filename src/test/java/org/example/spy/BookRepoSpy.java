package org.example.spy;

public class BookRepoSpy implements BookRepo {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
          saveCalled++;
          lastAddedBook = book;
    }
    public int timeCalled(){
        return saveCalled;
    }

    public boolean calledWith(Book book){
        return lastAddedBook.equals(book);
    }


}
