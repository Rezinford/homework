package home10.logic;

import home10.model.Book;
import home10.model.BookCategory;
import home10.model.BookType;
import home10.model.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoadLibrary {
    Library library = new Library();
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\TrackEnsure\\homework\\src\\main\\java\\home10\\file\\library.txt"))) {
            String line;
            while ( (line = reader.readLine())!=null){
                String[] param = line.split("\\|");
                Book book = new Book.NewBook()
                            .addTitle(param[0])
                            .addAuthor(param[1])
                            .addPages(Integer.parseInt(param[2]))
                            .addPrice(Double.parseDouble(param[3]))
                            .addBookType(BookType.REGULAR)
                            .addBookCategory(BookCategory.HardCover)
                            .build();
                library.addBooks(book);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public Library getLibrary() {
        return library;
    }
}
