package com.codegym.furama.controller;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String displayList(Model model) {
        model.addAttribute("customerList", customerService.findAllCustomer());
        return "views/customer/listCustomer";
    }

    @GetMapping("add")
    public String addForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerService.customerTypes());
        return "views/customer/form_add";
    }

    @PostMapping("/add")
    public String addConfirm(Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/";
    }
}
