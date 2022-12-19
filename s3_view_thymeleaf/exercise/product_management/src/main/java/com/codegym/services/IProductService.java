package com.codegym.services;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void addProduct(Product product);
    int findById(int id);
    boolean editProduct(Product product);
    boolean removeProduct(int id);
    Product getProduct(int id );
    List<Product> findByName(String name);
}
