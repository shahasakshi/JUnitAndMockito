package org.example.stub;

import java.util.List;

public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Book> getNewBooksWithAppliedDiscount(int discountRate,int days){
        List<Book> newBooks=bookRepo.findNewBooks(days);

        //500 apply 10%-->10% of 500-->50----500-50-->450

        for(Book book : newBooks){
           int price = book.getPrice();
           int newPrice = price - (discountRate *price/100);
           book.setPrice(newPrice);

        }
        return newBooks;
    }

}
