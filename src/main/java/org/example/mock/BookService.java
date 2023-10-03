package org.example.mock;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public void addBook(Book book){
        if(book.getPrice() > 400) {
            return;
        }
        bookRepo.save(book);

    }



}
