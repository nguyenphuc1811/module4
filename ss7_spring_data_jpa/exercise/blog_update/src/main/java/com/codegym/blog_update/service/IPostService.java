package com.codegym.blog_update.service;

import com.codegym.blog_update.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
}
