package com.codegym.furama.service.security;

import com.codegym.furama.model.security.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Integer id);
}
