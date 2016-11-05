package by.bsuir.webtech.lab_2.book_viewer;

import by.bsuir.webtech.lab_2.book.Book;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public interface IBookViewer {
    public final byte START_PAGE = 1;
    public ArrayList<Book> getPage(int page);
    public ArrayList<Book> nextPage();
    public ArrayList<Book> previewPage();
    public Book getNamedBook(String name);
}
