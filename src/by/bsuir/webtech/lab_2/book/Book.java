package by.bsuir.webtech.lab_2.book;

/**
 * Created by Max on 06.11.2016.
 */
public class Book {
    private String name;
    private String bookType;

    @Override
    public boolean equals(Object object) {
        Book book = (Book)object;
        if ((book.getName().equals(this.name)) && (book.getBookType().equals(this.bookType))) {
            return true;
        }
        return false;
    }

    public Book() {}

    public Book(String name,String bookType) {
        this.name = name;
        this.bookType = bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookType() {
        return bookType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
