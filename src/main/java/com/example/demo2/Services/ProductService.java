package com.example.demo2.Services;

import com.example.demo2.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(int pageNumber, int pageSize, String searchName);
    int getTotalPages(int pageSize, String searchName);
}
