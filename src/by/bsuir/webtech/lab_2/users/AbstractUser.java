package by.bsuir.webtech.lab_2.users;

import by.bsuir.webtech.lab_2.book.Book;
import by.bsuir.webtech.lab_2.book_viewer.BookViewer;
import by.bsuir.webtech.lab_2.book_viewer.UserBookViewer;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public abstract class AbstractUser {
    private String userName;
    private String email;
    private BookViewer bookViewer;
    private final byte START_PAGE = 1;

    //User operations
    public void viewCatalog() {
        viewCatalog(START_PAGE);
    }

    public void viewCatalog(int page) {
        ArrayList<Book> books = bookViewer.getPage(page);
        for (int i = 0; i < books.size(); i++)
            System.out.println(books.get(i));
    }

    public void viewPrevPage() {
        bookViewer.decCurrentPageIndex();
        viewCatalog(bookViewer.getCurrentPageIndex());
    }

    public void viewNextPage() {
        bookViewer.incCurrentPageIndex();
        viewCatalog(bookViewer.getCurrentPageIndex());
    }

    public void findBook(String name) {
        Book book = new Book();
        book = bookViewer.getNamedBook(name);
        System.out.println(book.getName() + "/" + book.getBookType());
    }
    //End user operations

    //Getter's - Setter's
    public BookViewer getBookViewer() {
        return bookViewer;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBookViewer(BookViewer bookViewer) {
        this.bookViewer = bookViewer;
    }
    //End Getter's - Setter's
}
