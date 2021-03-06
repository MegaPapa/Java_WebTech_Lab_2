package by.bsuir.webtech.lab_2.dao;

/**
 * Created by Max on 06.11.2016.
 */
public interface IDAO {
    //Constants
    public final String USER_FILE_PATH = "./data/users.txt";
    public final String BOOKS_DATA_FILE_PATH = "./data/books.txt";

    //Methods
    public Object getObjectByName(String name);
    public void addNewObjectToFile(Object object);
    public void deleteObjectFromFile(String name);
}
