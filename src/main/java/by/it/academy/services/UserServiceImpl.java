package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@RequiredArgsConstructor
public class  UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public void createUser(String name, String surname, int age) {
            userRepository.createUser(name, surname, age);
    }

    @SneakyThrows
    @Override
    public void authorizeUser(String login, String password) {
        userRepository.authorizeUser(login, password);
    }

    @SneakyThrows
    @Override
    public List<User> readUser() {
        return userRepository.readUser();
    }

    @SneakyThrows
    @Override
    public void updateUser(String name, String surname, int age) {
        userRepository.updateUser(name, surname, age);
    }

    @SneakyThrows
    @Override
    public void deleteUser() {
        userRepository.deleteUser();
    }
}
