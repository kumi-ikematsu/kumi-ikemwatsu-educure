package com.example.vocab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vocabulary_db",
                    "postgres",
                    "postgres"
            );
        }

        return connection;
    }
}
