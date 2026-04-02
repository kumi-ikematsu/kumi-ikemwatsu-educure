package com.example.vocab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/vocabulary_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public DBManager() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        initializeTable();
    }

    private void initializeTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS words ("
                + "id SERIAL PRIMARY KEY, "
                + "english VARCHAR(100) NOT NULL, "
                + "japanese VARCHAR(100) NOT NULL"
                + ")";
        try (Statement st = connection.createStatement()) {
            st.execute(sql);
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("DB切断エラー: " + e.getMessage());
        }
    }
}
