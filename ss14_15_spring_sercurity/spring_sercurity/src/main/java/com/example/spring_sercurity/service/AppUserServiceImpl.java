package com.example.spring_sercurity.service;

import com.example.spring_sercurity.model.AppUser;
import com.example.spring_sercurity.model.UserRole;
import com.example.spring_sercurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.spring_sercurity.repository.AppRoleRepository;
import com.example.spring_sercurity.repository.UserRoleRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void save(AppUser appUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

        appUser = appUserRepository.save(appUser);
        UserRole userRole = new UserRole();

        userRole.setAppRole(appRoleRepository.findById(appUser.getId()).get());
        userRole.setAppUser(appUser);

        userRoleRepository.save(userRole);
    }
}
