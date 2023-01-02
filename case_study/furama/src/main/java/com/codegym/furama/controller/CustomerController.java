package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.handler_exception.CustomerException;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import javafx.scene.web.WebHistory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String displayList(@RequestParam(name = "name", defaultValue = "") String name,
                              @RequestParam(name = "customerType", defaultValue = "0") int customerType,
                              @RequestParam(name = "email", defaultValue = "") String email,
                              @PageableDefault(size = 5) Pageable pageable,
                              Model model) {
        Page<Customer> customerPage;
        if (customerType == 0) {
            customerPage = customerService.searchCustomerAllType(name, email, pageable);
        } else {
            customerPage = customerService.searchCustomer(name, customerType, email, pageable);
        }
        model.addAttribute("customerTypeList", customerService.customerTypes());
        model.addAttribute("customerList", customerPage);
        return "views/customer/listCustomer";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerTypeList", customerService.customerTypes());
        return "views/customer/formAdd";
    }

    @PostMapping("/add")
    public String addConfirm(@Validated @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, Model attributes) {
        Map<String, String> errorMap = customerService.regexCustomer(customerDto);
        attributes.addAttribute("customerTypeList", customerService.customerTypes());
        attributes.addAttribute("customer", customerDto);
        if (bindingResult.hasErrors()) {
            return "views/customer/formAdd";
        }
        if (errorMap.isEmpty()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            attributes.addAttribute("mess", "Thêm mới thành công");
            customerService.editCustomer(customer);
        } else {
            for (Map.Entry<String, String> error : errorMap.entrySet()) {
                bindingResult.rejectValue(error.getKey(), error.getKey(), error.getValue());
            }
        }
        return "views/customer/formAdd";
    }

    @PostMapping("/delete")
    public String deleteCustomer(int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerService.customerTypes());
        return "views/customer/edit";
    }

    @PostMapping("/edit")
    public String editConfirm(Customer customer, RedirectAttributes model) {
        customerService.editCustomer(customer);
        model.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/customer";
    }
}
