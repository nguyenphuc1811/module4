package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    IProductService iPS;

    @RequestMapping("")
    public String display(Model model) {
        model.addAttribute("productList", iPS.selectAll());
        return "home";
    }

    @RequestMapping("/edit/{id}")
    public String displayEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", iPS.getProduct(id));
        return "edit";
    }

    @PostMapping("/editConfirm")
    public String displayEdit(Product product, Model model) {
        String mess = "Sửa Không thành công";
        if (iPS.editProduct(product)) {
            mess = "Sửa thành công";
        }
        model.addAttribute("mess", mess);
        return display(model);
    }

    @RequestMapping("/add")
    public String addForm() {
        return "add";
    }

    @PostMapping("/addConfirm")
    public String addConfirm(Product product, Model model) {
        product.setId(iPS.selectAll().get(iPS.selectAll().size() - 1).getId() + 1);
        iPS.addProduct(product);
        return display(model);
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes model) {
        String mess = "Xóa không thành công";
        if (iPS.removeProduct(id)) {
            mess = "Xóa thành công";
        }
        model.addFlashAttribute("mess", mess);
        return "redirect:/" ;
    }

    @RequestMapping("/view/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", iPS.getProduct(id));
        return "view";
    }

    @PostMapping("/search")
    public String searchProduct(String sName, Model model) {
        model.addAttribute("productList", iPS.findByName(sName));
        return "home";
    }
}
