package by.bsuir.webtech.lab_2.book_viewer;

import by.bsuir.webtech.lab_2.book.Book;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public class BookViewer implements IBookViewer{

    private int page;

    BookViewer() {
        page = START_PAGE;
    }

    @Override
    public ArrayList<Book> getPage(int page) {

        return null;
    }

    @Override
    public ArrayList<Book> nextPage() {
        return getPage(++page);
    }

    @Override
    public ArrayList<Book> previewPage() {
        if (page != 1)
            return getPage(--page);
        else
            return getPage(page);
    }

    @Override
    public Book getNamedBook(String name) {
        return null;
    }
}
