package home10;

import home10.logic.Control;

import java.io.IOException;

public class Main {
   public static final String FILE_PUCH;

    static {
        FILE_PUCH = "C:\\Java\\TrackEnsure\\homework\\src\\main\\java\\home10\\file\\library.txt";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Прогвмма запущена");
        new Control().start();
    }
}
