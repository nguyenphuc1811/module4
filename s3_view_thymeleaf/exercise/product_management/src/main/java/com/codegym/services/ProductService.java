package com.codegym.services;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> selectAll() {
        return productRepository.selectAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public int findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean editProduct(Product product) {
        return productRepository.editProduct(product);
    }

    @Override
    public boolean removeProduct(int id) {
        return productRepository.removeProduct(id);
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
