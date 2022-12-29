package com.codegym.blog_update.controller.rest;

import com.codegym.blog_update.model.Blog;
import com.codegym.blog_update.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/category")
    public ResponseEntity<List<String>> getCategory() {
        List<String> category = new ArrayList<>();
        for (Blog blog :
                blogService.findAll()) {
            category.add(blog.getCategory());
        }
        if (category.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getListBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/{category}")
    public ResponseEntity<List<Blog>> getBlog(@PathVariable("category") String category) {
        List<Blog> blogs = blogService.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog blog :
                blogs) {
            if (blog.getCategory().contains(category)) {
                blogList.add(blog);
            }
        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
