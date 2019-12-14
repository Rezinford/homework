package home07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        List<Integer> numderList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Java\\TrackEnsure\\homework\\src\\main\\java\\home07\\randomNumberSet.txt"))) {
            String line;
            if ((reader == null)) {
                System.out.println("File isEmpty");
            } else {
                while ((line = reader.readLine()) != null) {
                    String[] numderline = line.split(" ");
                    for (int i = 0; i < numderline.length; i++) {
                        numderList.add(Integer.parseInt(numderline[i]));
                    }
                }
                rewersViev(numderList);
                sumNumderWithString(numderList);
                sumNumder(numderList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rewersViev(List<Integer> list) {
        Collections.reverse(list);
        for (Number number : list) {
            System.out.println(number);
        }
    }

    private void rewersSortViev(List<Number> list) {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.toString());
    }

    private void sumNumderWithString(List<Integer> list) {
        Integer summ = 0;
        for (Integer number : list) {
            for (char c : number.toString().toCharArray()) {
                summ += Integer.parseInt(String.valueOf(c));
            }
        }
        System.out.println(summ);
    }

    private void sumNumder(List<Integer> list) {
        Integer summ = 0;
        for (Integer integer : list) {
            summ += summItemNumder(integer);

        }
        System.out.println(summ);
    }

    public Integer summItemNumder(Integer numder) {
        int asd = numder;
        int sum = 0;
        int last = numder % 10;
        while (asd != 0) {
            asd = asd / 10;
            sum += asd % 10;
        }
        sum += last;
        return sum;
    }


    private void newRandomFile() {
        try (PrintWriter writer = new PrintWriter("C:\\Java\\TrackEnsure\\homework\\src\\main\\java\\home07\\randomNumberSet.txt")) {
            Random random = new Random();
            int randomNumber = random.nextInt(69) + 1;
            for (int i = 0; i < randomNumber; i++) {
                int countNumder = random.nextInt(7);
                for (int j = 0; j <= countNumder; j++) {
                    if (j == 0) {
                        writer.print(random.nextInt(6000) + 1);
                    } else {
                        writer.print(" " + random.nextInt(6000) + 1);
                    }
                }
                writer.println();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
