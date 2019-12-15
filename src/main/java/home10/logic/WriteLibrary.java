package home10.logic;

import home10.model.Book;
import home10.model.Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteLibrary {

    public void write(List<Book> library, String filePuch, boolean saveInEnd) {

        try (FileWriter writer = new FileWriter(filePuch, saveInEnd)) {
            for (Book book : library) {
                String text = book.getTitle() + "|" +
                        book.getAuthor() + "|" +
                        book.getPages() + "|" +
                        book.getPrice() + "\n";

//                        + "|" +
//                        book.getBookType() + "|" +
//                        book.getBookCategory();

                        writer.write(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
