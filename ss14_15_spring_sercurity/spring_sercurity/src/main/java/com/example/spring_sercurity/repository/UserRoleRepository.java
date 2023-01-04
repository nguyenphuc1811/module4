package com.example.spring_sercurity.repository;

import com.example.spring_sercurity.model.AppUser;
import com.example.spring_sercurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findAllByAppUser(AppUser appUser);
}
