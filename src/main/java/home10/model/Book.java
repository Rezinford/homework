package home10.model;


public class Book {
    private String author;
    private String title;
    private int pages;
    private double price;
    private BookType bookType;
    private BookCategory bookCategory;

    public Book(String author, String title, int pages, double price, BookType bookType, BookCategory bookCategory) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.bookType = bookType;
        this.bookCategory = bookCategory;
    }
}
