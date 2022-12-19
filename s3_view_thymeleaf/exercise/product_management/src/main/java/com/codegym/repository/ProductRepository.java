package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Xe máy", 50, "yamaha", "hư"));
        productList.add(new Product(2, "Ô tô", 100, "bugati", "ổn"));
        productList.add(new Product(3, "Máy bay", 500, "vietjet", "ổn't"));
        productList.add(new Product(4, "Tàu ngầm", 1000, "mỹ", "vip"));
    }

    public List<Product> selectAll() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean editProduct(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                productList.set(findById(p.getId()), product);
                return true;
            }
        }
        return false;
    }

    public boolean removeProduct(int id) {
        if (findById(id) != -1) {
            productList.remove(findById(id));
            return true;
        }
        return false;
    }

    public Product getProduct(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(name))
                list.add(p);
        }
        return list;
    }
}
