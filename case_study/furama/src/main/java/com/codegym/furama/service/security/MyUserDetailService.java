package com.codegym.furama.service.security;

import com.codegym.furama.model.security.MyUserDetail;
import com.codegym.furama.model.security.User;
import com.codegym.furama.repository.security.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Tên đăng nhập: " + username + " không tồn tại!");
        }

        return new MyUserDetail(user);
    }
}
