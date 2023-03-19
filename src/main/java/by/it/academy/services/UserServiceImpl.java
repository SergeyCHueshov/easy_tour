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
    public void createUser(User user) {
            userRepository.createUser(user);
    }
    @SneakyThrows
    @Override
    public void authorizeUser(User user) {
        userRepository.authorizeUser(user);
    }

    @SneakyThrows
    @Override
    public User readUser(long id) {
        return userRepository.readUser(id);
    }
    @SneakyThrows
    @Override
    public List<User> readAllUsers() {
        return userRepository.readAllUsers();
    }

    @SneakyThrows
    @Override
    public void updateUser(Long id, String newPassword, String newLogin) {
        userRepository.updateUser(id, newPassword, newLogin);
    }

    @SneakyThrows
    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }
}
