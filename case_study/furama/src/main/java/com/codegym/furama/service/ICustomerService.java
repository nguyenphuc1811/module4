package com.codegym.furama.service;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    void addCustomer(Customer customer);
    public List<CustomerType> customerTypes();
}
