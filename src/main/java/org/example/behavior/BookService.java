package org.example.behavior;



import java.util.List;

public class BookService {

    private org.example.behavior.BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
       this.bookRepo = bookRepo;
    }
    public void addBook(Book book){
        if(book.getPrice() <= 500){
            return;
        }
        bookRepo.save(book);
    }
    public void addBook(BookRequest bookRequest){
        if(bookRequest.getPrice() <= 500){
            return;
        }
        org.example.behavior.Book book = new org.example.behavior.Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedlDate());
        bookRepo.save(book);


    }




}
