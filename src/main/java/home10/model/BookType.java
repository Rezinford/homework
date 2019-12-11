package home10.model;

public interface BookType {
    BookType NEW = ()->3;
    BookType CHILD = ()->30;
    BookType REGULAR = ()->15;

    int daysForReturn();
}
