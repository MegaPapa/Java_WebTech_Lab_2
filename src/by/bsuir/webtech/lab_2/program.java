package by.bsuir.webtech.lab_2;

import by.bsuir.webtech.lab_2.bean.users.AbstractUser;
import by.bsuir.webtech.lab_2.bean.users.Administrator;
import by.bsuir.webtech.lab_2.bean.users.User;
import by.bsuir.webtech.lab_2.controller.user_controller.UserController;

import java.util.Scanner;

/**
 * Created by Max on 06.11.2016.
 */
public class program {
    private static void adminLoop(String name) {
        Administrator administrator = new Administrator();
        System.out.println("Hi, " + name);
        while (true) {
            /* Admin command loop */
        }
    }

    private static void userLoop(String name) {
        User user = new User();
        System.out.println("Hi, "+ name);
        while (true) {
            /* User command loop */
        }
    }

    public static void main(String[] args) {
        AbstractUser abstractUser = new AbstractUser();
        AbstractUser user;
        Scanner scanner = new Scanner(System.in);
        String name;
        String password;
        do {
            System.out.println("Enter your name: ");
            name = scanner.next();
            System.out.println("Enter your password: ");
            password = scanner.next();
        } while ( (user = abstractUser.authorization(name,password)) == null);
        if (user.isAdmin()) {
            adminLoop(name);
        }
        else {
            userLoop(name);
        }
    }
}
