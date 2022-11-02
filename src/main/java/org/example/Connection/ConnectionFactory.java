package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //singleton (private constructor)
    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/EstacionamentoDB", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
