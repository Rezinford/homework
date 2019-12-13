package home10.logic;

import home10.model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LoadLibrary {
    Library library = new Library();
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\TrackEnsure\\homework\\src\\main\\java\\home10\\file\\library.txt"))) {
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
