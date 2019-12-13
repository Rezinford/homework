package home10;

import home10.logic.Control;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Прогвмма запущена");
        new Control().start();
    }
}
