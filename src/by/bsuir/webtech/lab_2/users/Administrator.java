package by.bsuir.webtech.lab_2.users;

import by.bsuir.webtech.lab_2.book_viewer.AdminBookViewer;

/**
 * Created by Max on 06.11.2016.
 */
public class Administrator extends AbstractUser {

    private AdminBookViewer adminBookViewer;

    public Administrator() {
        setBookViewer(new AdminBookViewer());
    }

    public void addNewBook() {

    }
}
