package com.codegym.furama.controller;

import com.codegym.furama.handler_exception.CustomerException;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String displayList(@RequestParam(name = "name", defaultValue = "") String name,
                              @RequestParam(name = "customerType", defaultValue = "") String customerType,
                              @RequestParam(name = "email", defaultValue = "") String email,
                              @PageableDefault(size = 5) Pageable pageable,
                              Model model) {
        Page<Customer> customerPage = customerService.searchCustomer(name, customerType, email, pageable);
        model.addAttribute("customerTypeList", customerService.customerTypes());
        model.addAttribute("customerList", customerPage);
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
    public String addConfirm(Customer customer, RedirectAttributes attributes) throws CustomerException {
        if (customerService.addCustomer(customer)) {
            attributes.addFlashAttribute("mess", "Thêm mới thành công");
        } else {
            attributes.addFlashAttribute("mess", "Thêm mới không thành công");
        }
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerService.customerTypes());
        return "views/customer/edit";
    }

    @PostMapping("edit")
    public String editConfirm(Customer customer, RedirectAttributes model) {
        customerService.editCustomer(customer);
        model.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/customer";
    }
}
