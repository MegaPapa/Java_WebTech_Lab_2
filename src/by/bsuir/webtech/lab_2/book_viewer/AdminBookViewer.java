package by.bsuir.webtech.lab_2.book_viewer;

import by.bsuir.webtech.lab_2.book.Book;
import by.bsuir.webtech.lab_2.dao.UsersDAO;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public class AdminBookViewer extends BookViewer {

    private UsersDAO usersDAO;

    public AdminBookViewer() {
        usersDAO = new UsersDAO();
    }

    public void addBook(String bookName,String bookType) {
        Book tmpBook = new Book(bookName,bookType);
        getBooksDAO().addNewObjectToFile(tmpBook);
        /* email sending */
    }

    public void deleteBook(String name) {
        getBooksDAO().deleteObjectFromFile(name);
    }

    public void editBook(String whoChanging,String newName,String newType) {
        deleteBook(whoChanging);
        addBook(newName,newType);
    }
}
