package by.bsuir.webtech.lab_2.book_viewer;

import by.bsuir.webtech.lab_2.book.Book;
import by.bsuir.webtech.lab_2.dao.BooksDAO;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public abstract class BookViewer {

    //Constants
    public final byte START_PAGE = 1;
    private int currentPageIndex;
    private BooksDAO booksDAO;

    public BookViewer() {
        booksDAO = new BooksDAO();
    }

    //Methods

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void decCurrentPageIndex() {
        currentPageIndex--;
    }

    public void incCurrentPageIndex() {
        currentPageIndex++;
    }

    public ArrayList<Book> getPage(int page) {
        currentPageIndex = page;
        return booksDAO.getBooksFromFile(currentPageIndex);
    }

    /*public ArrayList<Book> nextPage() {
        return getPage(++currentPageIndex);
    }


    public ArrayList<Book> previewPage() {
        if (currentPageIndex != 1)
            return getPage(--currentPageIndex);
        else
            return getPage(currentPageIndex);
    }
    */

    public Book getNamedBook(String name) {
        return booksDAO.getObjectByName(name);
    }

    public BooksDAO getBooksDAO() {
        return booksDAO;
    }
}
