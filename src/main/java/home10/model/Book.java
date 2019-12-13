package home10.model;


public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    private BookType bookType;
    private BookCategory bookCategory;

    public int daysForReturn() {
        return bookType.daysForReturn();
    }

    public int priceUp() {
        return bookCategory.priceUp();
    }

    public Book() {
        this.bookType = BookType.REGULAR;
        this.bookCategory = BookCategory.HardCover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + (price + priceUp()) +
                ", return=" +  daysForReturn() + " days" +
                '}';
    }

    public static class NewBook {
        private Book book;

        public NewBook() {
            book = new Book();
        }

        public NewBook addTitle(String title) {
            book.title = title;
            return this;
        }

        public NewBook addAuthor(String authorName) {
            book.author = authorName;
            return this;
        }

        public NewBook addPages(int pages) {
            book.pages = pages;
            return this;
        }

        public NewBook addPrice(double price) {
            book.price = price;
            return this;
        }

        public NewBook addBookType(BookType Type) {
            book.bookType = Type;
            return this;
        }

        public NewBook addBookCategory(BookCategory Category) {
            book.bookCategory = Category;
            return this;
        }

        public Book build() {
            return book;
        }
    }

}
