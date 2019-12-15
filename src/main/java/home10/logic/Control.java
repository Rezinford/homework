package home10.logic;

import home10.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static home10.Main.FILE_PUCH;
/*
        //Загрузить файл "Yes/No" -> "Y/N"
        //Выбор дейсьвия "Отобразть/Найти/Добавить"->"1/2/3"
             //1) Отобразить "Все/По типу" -> "1/2"
             //2) Выбор типв поисуа "/////"->"1/2/3/.../"
             //3) Введтье параметр поиска:
       //Добавить
             //1) Выберите "Тип"
             //2) Выберете категорию "Категория"
             //3) Введите данные книги
        //Обновить файл "Yes/No" -> "Y/N"
 */

public class Control {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Library library = new Library();

    public void start() throws IOException {
        startLogicMenu();
        savelist();
    }

    private void startLogicMenu() throws IOException {
        String pattern = "[0-4]";
        Pattern ptrn = Pattern.compile(pattern);
        while (true) {
            String line = startMenu();
            Matcher matcher = ptrn.matcher(line);
            if ((matcher.find())) {
                int num = Integer.parseInt(line); //scanner.nextInt();
                if (num > 0) {
                    if (num == 1) {
                        loadFile();
                    } else if (num == 2) {
                        printALLBook();
                    } else if (num == 3) {
                        findBook();
                    } else if (num == 4) {
                        addBookToLibrary();
                        savelist();
                    }
                } else {
                    System.out.println("Вы уверены что хотете выйти с программы? (Y/N)");
                    if (toDoIt(reader.readLine())) {
                        break;
                    }
                }
            }
        }
    }

    private void findBook() throws IOException {
        System.out.println("Введите слово для поиска: ");
        String line = reader.readLine(); //scanner.next();
        while (true) {
            if (line.length() != 0) {
                for (Book book : library.getBooks()) {
                    if (book.toString().contains(line)) {
                        System.out.println(book.toString());
                    }
                }
                break;
            }
        }

    }

    private String startMenu() throws IOException {
        System.out.println("Загрузить файл   - 1");
        System.out.println("Отобразть        - 2");
        System.out.println("Найти            - 3");
        System.out.println("Добавить         - 4");
        System.out.println("Заыершить работу - 0");
        return reader.readLine();
    }


    private boolean toDoIt(String work) {
//        String work = reader.readLine();
        while (true) {
            if (work.equals("Y")) {
                return true;
            } else if (work.equals("N")) {
                return false;
            }
        }

    }

    private void loadFile() throws IOException {
        LoadLibrary loadLibrary = new LoadLibrary();
        loadLibrary.load(FILE_PUCH);
        library = loadLibrary.getLibrary();
    }

    private void savelist() throws IOException {
        System.out.println("Сохранить изменения? (Y/N)");
        if (toDoIt(reader.readLine())) {
            WriteLibrary writeLibrary = new WriteLibrary();
            writeLibrary.write(library.getBooks(),FILE_PUCH,false );
        }
    }

    private void addBookToLibrary() throws IOException {
        System.out.println("Формат ввода:");
        System.out.println("Назывние книги|Автор|Количество страниц|цена");
        String line = reader.readLine(); //scanner.next();
        if (line.split("\\|").length == 4) {
            library.addBook(line);
        } else {
            System.out.println("Данные неправильного формата");
        }
    }

    private void printALLBook() {
        library.view();
    }


}
