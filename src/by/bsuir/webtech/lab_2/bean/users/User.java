package by.bsuir.webtech.lab_2.bean.users;

import by.bsuir.webtech.lab_2.bean.books.Book;
import by.bsuir.webtech.lab_2.controller.book_viewer.UserBookViewer;

/**
 * Created by Max on 06.11.2016.
 */
public class User extends AbstractUser {

    public User() {
        setBookViewer(new UserBookViewer());
    }

    public void offerBook(Book book) {
        /* Code with sending offer to admin's e-mail */
    }
}
