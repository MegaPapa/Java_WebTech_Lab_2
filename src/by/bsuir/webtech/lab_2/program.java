package by.bsuir.webtech.lab_2;

import by.bsuir.webtech.lab_2.book.Book;
import by.bsuir.webtech.lab_2.dao.BooksDAO;

/**
 * Created by Max on 06.11.2016.
 */
public class program {
    public static void main(String[] args) {
        BooksDAO booksDao = new BooksDAO();
        Book tmpBook = booksDao.getObjectByName("Война и мир - Лев Толстой");
        if (tmpBook != null)
            System.out.println(tmpBook.getName() + "/" + tmpBook.getBookType());
        else
            System.out.println("not found");
        Book newBook = new Book();
        booksDao.deleteObjectFromFile("Филосовия Java - Брюс Эккель");
        /*ArrayList<Book> bookArrayList = booksDao.getBooksFromFile(1);
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println(bookArrayList.get(i).getName());
        }*/
    }
}
