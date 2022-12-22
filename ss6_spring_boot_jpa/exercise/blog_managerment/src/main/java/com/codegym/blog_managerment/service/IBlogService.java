package com.codegym.blog_managerment.service;


import com.codegym.blog_managerment.model.Blog;

import java.util.List;


public interface IBlogService {
    List<Blog> findAll();

    Blog getById(int id);

    void deleteById(int id);

    boolean update(Blog blog);

}
