package com.codegym.blog_update.service;

import com.codegym.blog_update.model.Blog;
import com.codegym.blog_update.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    public Object getById(int id) {
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
    public void add(Blog blog){
        iBlogRepository.save(blog);
    }
}
