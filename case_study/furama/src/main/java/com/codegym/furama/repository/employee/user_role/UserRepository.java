package com.codegym.furama.repository.employee.user_role;

import com.codegym.furama.model.employee.user_role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
