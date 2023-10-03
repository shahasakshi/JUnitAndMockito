package org.example.dummy;

public class BookService {

    private BookRepo bookRepo;
    private EmailService emailService;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookService(BookRepo bookRepo, EmailService emailService) {
        this.bookRepo = bookRepo;
        this.emailService = emailService;
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }
    public int findNumberOfBooks(){
        return bookRepo.findAll().size();
    }

    //other methods which use email service

}
