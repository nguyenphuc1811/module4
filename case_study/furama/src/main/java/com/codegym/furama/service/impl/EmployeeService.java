package com.codegym.furama.service.impl;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.employee.IEmployeeRepository;
import com.codegym.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
