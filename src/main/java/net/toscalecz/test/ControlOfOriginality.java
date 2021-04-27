package net.toscalecz.test;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

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
