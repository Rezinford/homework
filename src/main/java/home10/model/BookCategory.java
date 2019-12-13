package home10.model;

public interface BookCategory {
    BookCategory HardCover = ()-> 10;
    BookCategory Paperback = ()-> 3;

    int priceUp();
}
