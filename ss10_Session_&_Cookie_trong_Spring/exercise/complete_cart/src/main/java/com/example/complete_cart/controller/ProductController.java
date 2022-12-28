package com.example.complete_cart.controller;

import com.example.complete_cart.util.CartDto;
import com.example.complete_cart.util.ExceptionProduct;
import com.example.complete_cart.util.ProductDto;
import com.example.complete_cart.model.Product;
import com.example.complete_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto createCart() {
        return new CartDto();
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("listProduct", iProductService.findAll());
        return "listProduct";
    }

    @GetMapping("detail/{id}")
    public String getDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id).orElse(null));
        return "detailProduct";
    }

    @GetMapping("buy/{id}")
    public String buyProduct(@PathVariable("id") int id, Model model, @ModelAttribute("cart") CartDto cart) {
        Optional<Product> product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cart.addProduct(productDto);
        model.addAttribute("listProduct", cart.getProductMap());
        return "cartShop";
    }

    @GetMapping("/buy/{id}")
    public String deleteCart(@PathVariable("id") int id, @ModelAttribute("cart") CartDto cart, Model model) throws ExceptionProduct {
        Optional<Product> product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cart.removeProduct(productDto);
        model.addAttribute("listProduct", cart.getProductMap());
        return "cartShop";
    }
}
