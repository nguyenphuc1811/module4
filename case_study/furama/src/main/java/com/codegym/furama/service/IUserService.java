package com.codegym.furama.service;

import com.codegym.furama.model.employee.user_role.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Integer id);
}