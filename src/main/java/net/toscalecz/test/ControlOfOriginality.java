package net.toscalecz.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Deprecated
public class ControlOfOriginality {

    public static boolean checkUserName(String userName, Connection connection) throws SQLException {
        boolean original = true;
        Statement statements = connection.createStatement();
        ResultSet rs = statements.executeQuery("SELECT userName FROM users");
        while (rs.next()) {
            String lastName = rs.getString("userName");
            if (lastName.equals(userName)) {
                original = false;
            }
        }
        return original;
    }
}
