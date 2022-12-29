package com.codegym.furama.service.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.ICustomerRepository;
import com.codegym.furama.repository.ICustomerTypeRepository;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Page<Customer> searchCustomer(String name, String nameType, String email, Pageable pageable) {
        return customerRepository.searchCustomer(name, nameType, email, pageable);
    }

    public boolean addCustomer(Customer customer) {
        for (Customer c :
                findAllCustomer()) {
            if (c.getId() == customer.getId()) {
                return false;
            }
        }
        customerRepository.save(customer);
        return true;
    }

    public List<CustomerType> customerTypes() {
        return iCustomerTypeRepository.findAll();
    }

    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public void editCustomer(Customer customer){
        customerRepository.save(customer);
    }
}