package com.codegym.services;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void addProduct(Product product);
    Product findById(int id);
    boolean editProduct(Product product);
    boolean removeProduct(Product product);
    List<Product> findByName(String name);
}
