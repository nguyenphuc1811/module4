package com.codegym.furama.service;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    void addCustomer(Customer customer);

    public List<CustomerType> customerTypes();

    Page<Customer> searchCustomer(String name, String nameType, Pageable pageable);
}
