package com.codegym.furama.service;

import com.codegym.furama.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
