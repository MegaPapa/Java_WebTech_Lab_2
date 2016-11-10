package by.bsuir.webtech.lab_2.dao;

import by.bsuir.webtech.lab_2.bean.books.Book;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Max on 06.11.2016.
 */
public class BooksDAO implements IDAO{


    public final int BOOKS_ON_PAGE = 5;
    private final String SPLITTER = "<->";
    private final byte NAME_INDEX = 0;
    private final byte TYPE_INDEX = 1;
    private final byte INVALID_INDEX = -1;
    private final char NEW_LINE = '\n';

    private Book getBookFromLine(String line) {
        Book result = new Book();
        String[] bookInfo = line.split(SPLITTER);
        result.setName(bookInfo[NAME_INDEX]);
        result.setBookType(bookInfo[TYPE_INDEX]);
        return result;
    }

    private void rewriteFile(String newText,String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(newText);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findBookIndex(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_DATA_FILE_PATH))){
            String line;
            int index = 0;
            while (( (line = bufferedReader.readLine()) != null ) ) {
                Book tmpBook = getBookFromLine(line);
                if (tmpBook.getName().equals(name))
                    return index;
                index++;
            }
            return INVALID_INDEX;
        }
        catch (IOException e) {
            System.out.println(e);
            return INVALID_INDEX;
        }
    }

    public ArrayList<Book> getBooksFromFile(int page) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_DATA_FILE_PATH))){
            String line;
            for (int i = 0; i < ((page-1)*BOOKS_ON_PAGE); i++)
                bufferedReader.readLine();

            ArrayList<Book> result = new ArrayList<Book>();
            int count = 0;
            while (( (line = bufferedReader.readLine()) != null ) ) {
                if (count == BOOKS_ON_PAGE)
                    break;
                result.add(getBookFromLine(line));
                count++;
            }
            return result;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getObjectByName(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_DATA_FILE_PATH))) {
            int bookIndex = findBookIndex(name);
            if (bookIndex == INVALID_INDEX)
                return null;
            for (int i = 0; i < bookIndex; i++)
                bufferedReader.readLine();
            String line = bufferedReader.readLine();
            return getBookFromLine(line);
        }
        catch (IOException e) {
            return null;
        }
    }

    @Override
    public void addNewObjectToFile(Object object) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_DATA_FILE_PATH,true))) {
            Book book = (Book)object;
            writer.write(NEW_LINE + book.getName() + SPLITTER + book.getBookType());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteObjectFromFile(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_DATA_FILE_PATH))) {
            StringBuilder resultText = new StringBuilder("");
            String line;
            int deletedLineIndex = findBookIndex(name);

            int counter = -1;
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
                if (counter == deletedLineIndex)
                    continue;
                resultText.append(line + NEW_LINE);
            }
            resultText.setLength(resultText.length() - 1); //Delete last char
            rewriteFile(resultText.toString(),BOOKS_DATA_FILE_PATH);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
