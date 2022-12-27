package com.codegym.furama.controller;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String displayList(@RequestParam(name = "searchName", defaultValue = "") String name,
                              @RequestParam(name = "customerType", defaultValue = "") String customerType,
                              @PageableDefault(size = 5) Pageable pageable,
                              Model model) {
        Page<Customer> customerPage = customerService.searchCustomer(name,customerType,pageable);
        model.addAttribute("customerList",customerPage);
        return "views/customer/list_customer";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Customer customer = new Customer();
        customer.setGender(true);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerService.customerTypes());
        return "views/customer/form_add";
    }

    @PostMapping("/add")
    public String addConfirm(Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customer";
    }
}
