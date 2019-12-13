package home10.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }
    public void view(){
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


}
