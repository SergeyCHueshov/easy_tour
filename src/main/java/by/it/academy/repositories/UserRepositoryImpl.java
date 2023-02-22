package by.it.academy.repositories;

import by.it.academy.entities.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {

    @SneakyThrows
    @Override
    public void createUser(String name, String surname, int age) {
        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pr = conn.prepareStatement(
                    "INSERT INTO person_user (name, surname, age)VALUES (?,?,?)");
            pr.setString(1, name);
            pr.setString(2, surname);
            pr.setInt(3, age);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public void authorizeUser(String login, String password) {
        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pr = conn.prepareStatement(
                    "INSERT INTO user_authorization (login, password)VALUES (?,?)");
            pr.setString(1, login);
            pr.setString(2, password);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @SneakyThrows
    @Override
    public List<User> readUser() {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement("SELECT * FROM person_user, user_authorization");
        ResultSet resultSet = pr.executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setName(resultSet.getString(1));
            user.setSurname(resultSet.getString(2));
            user.setAge(resultSet.getInt(3));
            user.setLogin(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
            users.add(user);
        }
    return users;
}
    @SneakyThrows
    @Override
    public void updateUser(String name, String surname, int age) {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement("UPDATE person_user SET name=?, surname=?, age=? WHERE id=?");
        pr.setString(1, name);
        pr.setString(2, surname);
        pr.setInt(3, age);
        pr.executeUpdate();
    }

    @SneakyThrows
    @Override
    public void deleteUser() {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement("DELETE FROM person_user WHERE id=?");
        ResultSet rs = pr.getResultSet();
        rs.deleteRow();
        pr.executeUpdate();
    }

}
