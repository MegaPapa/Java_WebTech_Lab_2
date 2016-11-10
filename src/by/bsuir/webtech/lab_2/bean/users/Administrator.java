package by.bsuir.webtech.lab_2.bean.users;

import by.bsuir.webtech.lab_2.controller.book_viewer.AdminBookViewer;

/**
 * Created by Max on 06.11.2016.
 */
public class Administrator extends AbstractUser {

    private AdminBookViewer adminBookViewer;

    public Administrator() {
        setBookViewer(new AdminBookViewer());
    }

    public void addNewBook(String name,String bookType) {
        AdminBookViewer adminBookViewer = (AdminBookViewer)getBookViewer();
        adminBookViewer.addBook(name,bookType);
    }

    public void deleteBook(String name) {
        AdminBookViewer adminBookViewer = (AdminBookViewer)getBookViewer();
        adminBookViewer.deleteBook(name);
    }

    public void editBook(String whoChanging,String newName,String newBookType) {
        AdminBookViewer adminBookViewer = (AdminBookViewer)getBookViewer();
        adminBookViewer.editBook(whoChanging,newName,newBookType);
    }
}
