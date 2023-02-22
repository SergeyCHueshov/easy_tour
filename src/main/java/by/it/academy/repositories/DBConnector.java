package by.it.academy.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            final String url = "jdbc:postgresql://127.0.0.1:5432/Web_tour";
            final String user = "postgres";
            final String password = "sergeychueshov";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
