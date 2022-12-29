package com.codegym.blog_update.service;

import com.codegym.blog_update.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {
    List<Blog> findAll();

    Object getById(int id);

    void deleteById(int id);

    boolean update(Blog blog);

    void add(Blog blog);

    Boolean existsByTitle(String title);
}
