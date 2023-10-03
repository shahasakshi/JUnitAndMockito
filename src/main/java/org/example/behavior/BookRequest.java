package org.example.behavior;

import java.time.LocalDate;

public class BookRequest {
    private String title;
    private int price;
    private LocalDate publishedlDate;

    public BookRequest() {
    }

    public BookRequest(String title, int price, LocalDate publishedlDate) {
        this.title = title;
        this.price = price;
        this.publishedlDate = publishedlDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedlDate() {
        return publishedlDate;
    }

    public void setPublishedlDate(LocalDate publishedlDate) {
        this.publishedlDate = publishedlDate;
    }
}
