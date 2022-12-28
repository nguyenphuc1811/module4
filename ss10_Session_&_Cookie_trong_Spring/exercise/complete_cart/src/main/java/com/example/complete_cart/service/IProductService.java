package com.example.complete_cart.service;

import com.example.complete_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
}
