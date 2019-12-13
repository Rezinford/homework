package home10.logic;

import home10.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    //    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    public void start() throws IOException {
        System.out.println("Загрузить файл  Y or N");
        while (true) {

//            String work = scanner.nextLine();
            String work = reader.readLine();
            if (work.equals("Y")) {
                loadFile();
                workWithBookList();
                break;
            } else if (work.equals("N")) {
                break;
            }
        }
    }

    private void loadFile() {
        LoadLibrary loadLibrary = new LoadLibrary();
        loadLibrary.load();
        library = loadLibrary.getLibrary();
    }

    private void workWithBookList() throws IOException {
        String pattern = "(\\d)";
        Pattern ptrn = Pattern.compile(pattern);
        while (true) {
            System.out.println("Выбор дейсьвия: Отобразть Найти Добавить -> 1/2/3");
            System.out.println("Для выхода нажмите 0");

            String line = reader.readLine();
            Matcher matcher = ptrn.matcher(line);
            if ((matcher.find())) {
                int num = Integer.parseInt(line); //scanner.nextInt();
                if (num > 0) {
                    if (num == 1) {
                        printALLBook();
                    } else if (num == 2) {
                        System.out.println("Функция еще не реализоанв");
                    } else if (num == 3) {
                        addBookToLibrary();
                    }
                } else {
                    break;
                }
            }
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
//        }

    }

    private void printALLBook() {
        library.view();
    }


}
