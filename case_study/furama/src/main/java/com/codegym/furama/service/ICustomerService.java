package com.codegym.furama.service;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    boolean addCustomer(Customer customer);

    List<CustomerType> customerTypes();

    Page<Customer> searchCustomer(String name, int customerType, String email, Pageable pageable);

    Optional<Customer> findById(int id);

    void deleteCustomer(int id);

    void editCustomer(Customer customer);

    Page<Customer> searchCustomerAllType(String name, String email, Pageable pageable);

    Map<String, String> regexCustomer(CustomerDto customerDto);
}
