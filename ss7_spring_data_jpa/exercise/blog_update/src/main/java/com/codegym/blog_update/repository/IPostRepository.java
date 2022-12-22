package com.codegym.blog_update.repository;

import com.codegym.blog_update.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Integer> {
}
