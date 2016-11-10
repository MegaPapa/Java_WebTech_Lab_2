package by.bsuir.webtech.lab_2.bean.books;

/**
 * Created by Max on 06.11.2016.
 */
public class Book {
    private String name;
    private String bookType;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || (getClass() != object.getClass())) {
            return false;
        }
        Book book = (Book)object;
        if ((book.getName().equals(this.name)) && (book.getBookType().equals(this.bookType))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "/" + bookType;
    }

    @Override
    public int hashCode() {
        final int MAGIC_NUMBER = 89;
        int result = (name != null ? result = name.hashCode() : 0);
        result = MAGIC_NUMBER*result + (bookType != null ? result = bookType.hashCode() : 0);
        return result;
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
