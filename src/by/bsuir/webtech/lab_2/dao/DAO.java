package by.bsuir.webtech.lab_2.dao;

import by.bsuir.webtech.lab_2.book.Book;

import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public class DAO implements IDAO{

    @Override
    public ArrayList<Book> getBooksForPage(int page) {
        return null;
    }

    @Override
    public Book getNamedBook(String name) {
        return null;
    }

    @Override
    public void addBookToFile(Book book) {

    }

    @Override
    public void deleteBookFromFile(String name) {

    }
}
