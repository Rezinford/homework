package home10.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void view(){
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void addBook(String line){
        String[] param = line.split("\\|");
        Book book = new Book.NewBook()
                .addTitle(param[0])
                .addAuthor(param[1])
                .addPages(Integer.parseInt(param[2]))
                .addPrice(Double.parseDouble(param[3]))
                .addBookType(BookType.REGULAR)
                .addBookCategory(BookCategory.HardCover)
                .build();
        addBook(book);
    }


}
