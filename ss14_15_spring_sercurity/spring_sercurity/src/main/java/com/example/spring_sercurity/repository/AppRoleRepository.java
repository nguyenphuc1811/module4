package com.example.spring_sercurity.repository;

import com.example.spring_sercurity.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole , Long> {
}
