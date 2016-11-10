package by.bsuir.webtech.lab_2.dao;

import by.bsuir.webtech.lab_2.bean.users.AbstractUser;

import java.io.*;

/**
 * Created by Max on 06.11.2016.
 */
public class UsersDAO implements IDAO{
    private final String SPLITTER = "!-!";
    private final byte NAME_INDEX = 0;
    private final byte EMAIL_INDEX = 1;
    private final byte PASSWORD_INDEX = 2;
    private final byte GROUP_INDEX = 3;
    private final String ADMIN_GROUP = "1";
    private final byte USER_GROUP = 0;
    private final char NEW_LINE = '\n';

    private AbstractUser getUserFromLine(String line) {
        AbstractUser user = new AbstractUser();
        String[] userInfo = line.split(SPLITTER);
        user.setEmail(userInfo[EMAIL_INDEX]);
        user.setUserName(userInfo[NAME_INDEX]);
        user.setPassword(Integer.parseInt(userInfo[PASSWORD_INDEX]));
        user.setAdmin(userInfo[GROUP_INDEX].equals(ADMIN_GROUP));
        return user;
    }

    @Override
    public AbstractUser getObjectByName(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                AbstractUser user = new AbstractUser();
                if ( (user = getUserFromLine(line)).getUserName().equals(name)) {
                    return user;
                }
            }
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addNewObjectToFile(Object object) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_DATA_FILE_PATH,true))) {
            AbstractUser user = (AbstractUser) object;
            writer.write(NEW_LINE + user.getUserName() + SPLITTER + user.getEmail() + SPLITTER + user.getPassword() + SPLITTER + (user.isAdmin() ? ADMIN_GROUP : USER_GROUP));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteObjectFromFile(String name) {

    }
}
