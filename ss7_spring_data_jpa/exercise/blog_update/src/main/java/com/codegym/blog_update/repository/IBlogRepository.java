package com.codegym.blog_update.repository;

import com.codegym.blog_update.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Override
    Page<Blog> findAll(Pageable pageable);
}
