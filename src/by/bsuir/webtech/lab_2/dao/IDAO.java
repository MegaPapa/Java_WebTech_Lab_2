package by.bsuir.webtech.lab_2.dao;

import by.bsuir.webtech.lab_2.book.Book;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public interface IDAO {
    final int BOOKS_ON_PAGE = 5;
    public ArrayList<Book> getBooksForPage(int page);
    public Book getNamedBook(String name);
    public void addBookToFile(Book book);
    public void deleteBookFromFile(String name);
}
