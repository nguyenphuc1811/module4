package com.codegym.furama.service.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.ICustomerRepository;
import com.codegym.furama.repository.ICustomerType;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    ICustomerType iCustomerType;

    public List<Customer> findAllCustomer (){
       return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public List<CustomerType> customerTypes(){
        return iCustomerType.findAll();
    }
}