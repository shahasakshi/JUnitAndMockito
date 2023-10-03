package org.example.fake;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }
    public int findNumberOfBooks(){
        return bookRepo.findAll().size();
    }
}
