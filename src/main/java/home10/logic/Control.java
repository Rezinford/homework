package home10.logic;

import home10.logic.LoadLibrary;
import home10.model.Book;
import home10.model.BookCategory;
import home10.model.BookType;
import home10.model.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
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
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    public void start() {
        System.out.println("Загрузить файл  Y or N");
        while (true) {
            String work = scanner.nextLine();
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

    private void workWithBookList() {
        while (true) {
            System.out.println("Выбор дейсьвия: Отобразть Найти Добавить -> 1/2/3");
            System.out.println("Для выхода нажмите 0");
            int num = scanner.nextInt();
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

    private void addBookToLibrary() {
        System.out.println("Формат ввода:");
        System.out.println("Назывние книги|Автор|Количество страниц|цена");
        String line = scanner.next();
        String[] param = line.split("\\|");
        if (param.length == 4) {
            Book book = new Book.NewBook()
                    .addTitle(param[0])
                    .addAuthor(param[1])
                    .addPages(Integer.parseInt(param[2]))
                    .addPrice(Double.parseDouble(param[3]))
                    .build();
            library.addBooks(book);

        } else {
            System.out.println("Данные неправильного формата");
        }
//        }

    }

    private void printALLBook() {
        library.view();
    }


}
