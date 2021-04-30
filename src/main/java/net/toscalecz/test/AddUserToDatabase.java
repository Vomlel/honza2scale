package net.toscalecz.test;

import net.toscalecz.test.others.Hashing;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//run will add user to database
public class AddUserToDatabase {

    //There is specified user to be added
    //TODO maybe get userName and password out of this method and use database from config BUG #5
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users1", "testUser", "testUser")) {
            add("Jan", "ddsad", connection);
        }
    }
    //There is adding user to database (with hashed password)
    private static void add(String userName, String password, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (userName, password) VALUES (?, ?)");
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, Hashing.hashThisString(password));
        preparedStatement.executeUpdate();
    }
}