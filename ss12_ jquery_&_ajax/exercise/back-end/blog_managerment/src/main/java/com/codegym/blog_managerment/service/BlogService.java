package com.codegym.blog_managerment.service;

import com.codegym.blog_managerment.model.Blog;
import com.codegym.blog_managerment.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    public Blog getById(int id) {
        return iBlogRepository.getReferenceById(id);
    }

    public void deleteById(int id) {
        iBlogRepository.deleteById(id);
    }

    public boolean update(Blog blog) {
        try {
            if (!iBlogRepository.existsById(blog.getId())) {
                throw new SQLException();
            } else {
                iBlogRepository.save(blog);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


}
