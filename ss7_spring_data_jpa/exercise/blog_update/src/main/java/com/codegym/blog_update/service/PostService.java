package com.codegym.blog_update.service;

import com.codegym.blog_update.model.Post;
import com.codegym.blog_update.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    @Override
    public List<Post> findAll() {
        return iPostRepository.findAll();
    }
}
