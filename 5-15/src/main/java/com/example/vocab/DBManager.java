package com.example.vocab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/vocabulary_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public DBManager() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("DB接続エラー: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                initializeDatabase();
            }
        } catch (SQLException e) {
            System.err.println("DB接続確認エラー: " + e.getMessage());
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
