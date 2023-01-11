package com.codegym.furama.repository.security;

import com.codegym.furama.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
