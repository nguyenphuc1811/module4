package com.codegym.blog_update.service;

import com.codegym.blog_update.model.Blog;
import com.codegym.blog_update.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.sql.SQLException;

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
            if (iBlogRepository.existsByTitle(blog.getTitle())) {
                throw new SQLException("Title is already exists");
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

    public Boolean existsByTitle(String title){
       return iBlogRepository.existsByTitle(title);
    }


}
