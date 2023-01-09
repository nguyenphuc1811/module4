package com.codegym.furama.service.impl;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerRepository;
import com.codegym.furama.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public Page<Customer> searchCustomer(String name, int customerType, String email, Pageable pageable) {
        return customerRepository.searchCustomer(name, customerType, email, pageable);
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

    public Map<String, String> regexCustomer(CustomerDto customerDto) {
        Map<String, String> errorMap = new LinkedHashMap<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getId() != customerDto.getId()) {
                if (customer.getEmail().equals(customerDto.getEmail())) {
                    errorMap.put("email", "Email đã tồn tại");
                }
                if (customer.getIdCard().equals(customerDto.getIdCard())) {
                    errorMap.put("idCard", "ID Card đã tồn tại");
                }
                if (customer.getPhoneNumber().equals(customerDto.getPhoneNumber())) {
                    errorMap.put("phoneNumber", "Số điện thoại đã tồn tại");
                }
            }
        }
        return errorMap;
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

    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomerAllType(String name, String email, Pageable pageable) {
        return customerRepository.searchCustomerAllType(name, email, pageable);
    }
}