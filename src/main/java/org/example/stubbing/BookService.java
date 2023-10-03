package org.example.stubbing;

import java.util.List;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks=bookRepo.findNewBooks(days);

        //500 apply 10%-->10% of 500-->50----500-50-->450

        for(Book book : newBooks){
           int price = book.getPrice();
           int newPrice = price - (discountRate *price/100);
           book.setPrice(newPrice);

        }
        return newBooks;
    }

    public int calculateTotalCost(List<String> booksIds) {
        int total = 0;
        for(String bookId :booksIds){
           Book book=  bookRepo.findBookById(bookId);
           total = total + book.getPrice();

        }
        return total;
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }
    public void addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedlDate());
        bookRepo.save(book);

    }
}
