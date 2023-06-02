package com.example.demo2.Services;

import com.example.demo2.entity.Product;
import com.example.demo2.Repositories.ProductReporitory;

import java.util.List;

public class DefaultProductService implements ProductService{
    private ProductReporitory productRepository;

    public DefaultProductService(ProductReporitory productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(int pageNumber, int pageSize, String searchName) {
        return productRepository.getProducts(pageNumber, pageSize, searchName);
    }

    @Override
    public int getTotalPages(int pageSize, String searchName) {
        int totalProducts = productRepository.getTotalProducts(searchName);
        return (int) Math.ceil((double) totalProducts / pageSize);
    }
}
