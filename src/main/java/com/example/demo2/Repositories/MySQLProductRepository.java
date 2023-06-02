package com.example.demo2.Repositories;

import com.example.demo2.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MySQLProductRepository implements ProductReporitory {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_lab2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Override
    public List<Product> getProducts(int pageNumber, int pageSize, String searchName) {
        List<Product> products = new ArrayList<>();
        int offset = (pageNumber - 1) * pageSize;
        String query = "SELECT * FROM product WHERE name LIKE ? LIMIT ?, ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + searchName + "%");
            statement.setInt(2, offset);
            statement.setInt(3, pageSize);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    Product product = new Product(id, name, price);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int getTotalProducts(String searchName) {
        int totalProducts = 0;
        String query = "SELECT COUNT(*) AS total FROM product WHERE name LIKE ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + searchName + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    totalProducts = resultSet.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalProducts;
    }
}
