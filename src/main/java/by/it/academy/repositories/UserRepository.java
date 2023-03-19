package by.it.academy.repositories;

import by.it.academy.entities.User;

import java.util.List;

public interface UserRepository {

    void createUser(User user);
    void authorizeUser(User user);
    User readUser(long id);
    List<User> readAllUsers();
    void updateUser(Long id, String newPassword, String newLogin);
    void deleteUser(Long id);
}

