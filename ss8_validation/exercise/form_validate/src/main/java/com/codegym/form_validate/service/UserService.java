package com.codegym.form_validate.service;

import com.codegym.form_validate.model.User;
import com.codegym.form_validate.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    public void save(User user) {
        iUserRepository.save(user);
    }
}
