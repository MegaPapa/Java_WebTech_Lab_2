package by.bsuir.webtech.lab_2.controller.user_controller;

import by.bsuir.webtech.lab_2.dao.UsersDAO;
import by.bsuir.webtech.lab_2.bean.users.User;

/**
 * Created by Max on 10.11.2016.
 */
public class UserController {
    private UsersDAO usersDAO;

    public UserController() { usersDAO = new UsersDAO(); }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public void addUser(String name,String email,int password) {
        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(false);
        usersDAO.addNewObjectToFile(user);
    }
}
