package by.bsuir.webtech.lab_2.users;

import by.bsuir.webtech.lab_2.book.Book;
import by.bsuir.webtech.lab_2.book_viewer.UserBookViewer;

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
