import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class AddUserToDatabase {
    public static void main(String args[]) throws SQLException, NoSuchAlgorithmException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users1","testUser","testUser");
        try {
            add("Honza", "ddad", connection);
        } finally {
            connection.close();
        }
    }
    private static void add(String userName, String password, Connection connection) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users "+
                "(userName, password) VALUES (?, ?)");
        if (ControlOfOriginality.checkUserName(userName, connection)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, Hashing.hashThisString(password));
            preparedStatement.executeUpdate();
            System.out.println(userName + " is added.");
        } else {
            System.out.println(userName + " is not added (duplicity).");
        }
    }
}