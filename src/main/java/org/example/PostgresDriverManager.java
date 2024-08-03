package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDriverManager {
    private static PostgresDriverManager instance;
    private static String URL = "jdbc:postgresql://localhost:5432/lesson41";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "password";

    private PostgresDriverManager() {
        init();
    }

    private void init() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PostgresDriverManager getInstance() {
        if (instance == null) {
            instance = new PostgresDriverManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}