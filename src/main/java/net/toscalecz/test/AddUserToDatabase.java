package net.toscalecz.test;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//for add user to database
public class AddUserToDatabase {

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users1", "testUser", "testUser")) {
            add("Jan", "ddsad", connection);
        }
    }

    private static void add(String userName, String password, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (userName, password) VALUES (?, ?)");
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, Hashing.hashThisString(password));
        preparedStatement.executeUpdate();
    }
}