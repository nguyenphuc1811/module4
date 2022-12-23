package com.codegym.form_validate.repository;

import com.codegym.form_validate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
