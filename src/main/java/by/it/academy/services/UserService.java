package by.it.academy.services;

import by.it.academy.entities.User;
import lombok.SneakyThrows;

import java.util.List;

public interface UserService {

    @SneakyThrows
    void createUser(User user);

    @SneakyThrows
    void authorizeUser(User user);

    @SneakyThrows
    User readUser(long id);

    @SneakyThrows
    List<User> readAllUsers();

    @SneakyThrows
    void updateUser(Long id, String newPassword, String newLogin);

    @SneakyThrows
    void deleteUser(long id);
}


