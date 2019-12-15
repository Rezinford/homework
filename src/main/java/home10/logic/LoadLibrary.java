package home10.logic;

import home10.model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LoadLibrary {
    private Library library = new Library();
    public void load(String filePuch) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePuch))) {
            String line;
            while ( (line = reader.readLine())!=null){
                library.addBook(line);
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
