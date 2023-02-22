package by.it.academy.services;

import by.it.academy.entities.User;

import java.util.List;

public interface UserService {
    void createUser(String name, String surname, int age);

    void authorizeUser(String login, String password);

    List<User> readUser();

    void updateUser(String name, String surname, int age);

    void deleteUser();
}
