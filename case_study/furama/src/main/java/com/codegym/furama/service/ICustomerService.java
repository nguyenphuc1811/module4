package com.codegym.furama.service;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    void addCustomer(Customer customer);

     List<CustomerType> customerTypes();

    Page<Customer> searchCustomer(String name, String nameType, String email, Pageable pageable);

    Optional<Customer> findById(int id);

    void deleteCustomer(int id);
}
