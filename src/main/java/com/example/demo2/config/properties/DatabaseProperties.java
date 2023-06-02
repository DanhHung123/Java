package com.example.demo2.config.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Setter
@Getter
@Data
public class DatabaseProperties {
    private String url;
    private String username;
    private String password;
    private String driver;

    public  DatabaseProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            this.setUrl(properties.getProperty("db.url").trim());
            this.setUsername(properties.getProperty("db.username").trim());
            this.setPassword(properties.getProperty("db.password").trim());
            this.setDriver(properties.getProperty("database.properties.driver-class-name").trim());
        } catch (IOException e) {
            System.err.println("Error");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        System.out.println(databaseProperties);
//        Properties properties = new Properties();
//
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//        try (InputStream fis = classLoader.getResourceAsStream("application.properties");) {
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String dbUrl = properties.getProperty("db.url");
//        String username = properties.getProperty("db.username");
//        String password = properties.getProperty("db.password");
//
//        System.out.println("Url: " + dbUrl);
//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
    }
}
