package com.example.demo2.config.db;
import com.example.demo2.config.properties.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
    private static DbConnection instance = null;
    private Connection conn = null;

    private DbConnection() {}

    private void init() throws SQLException {
        DatabaseProperties dbProps = new DatabaseProperties();
        final String DB_URL = dbProps.getUrl();
        final String USER = dbProps.getUsername();
        final String PASS = dbProps.getPassword();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected to database");
    }

    public Connection getConnection() {
        return conn;
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance;
        } else {
            instance = new DbConnection();
            instance.init();
            return instance;
        }
    }
}
