package com.example.demo2.Repositories;

import com.example.demo2.entity.Product;

import java.util.List;

public interface ProductReporitory {
    List<Product> getProducts(int pageNumber, int pageSize, String searchName);
    int getTotalProducts(String searchName);
}
