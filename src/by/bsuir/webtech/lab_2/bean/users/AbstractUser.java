package by.bsuir.webtech.lab_2.bean.users;

import by.bsuir.webtech.lab_2.bean.books.Book;
import by.bsuir.webtech.lab_2.controller.book_viewer.BookViewer;
import by.bsuir.webtech.lab_2.controller.user_controller.UserController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public class AbstractUser {
    private String userName;
    private String email;
    private BookViewer bookViewer;
    private Integer password;
    private boolean isAdmin;
    private UserController userController;

    public AbstractUser() {
        userController = new UserController();
    }

    //User operations
    public AbstractUser authorization(String name,String password) {
        AbstractUser result;
        if ((result = userController.getUsersDAO().getObjectByName(name)) == null) {
            return null;
        }
        if (result.password.hashCode() == password.hashCode()) {
            return result;
        }
        return null;
    }

    public void viewCatalog() {
        final byte START_PAGE = 1;
        viewCatalog(START_PAGE);
    }

    private void viewCatalog(int page) {
        ArrayList<Book> books = bookViewer.getPage(page);
        for (Book book : books) System.out.println(book);
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    //End Getter's - Setter's
}
