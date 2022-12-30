package com.codegym.blog_managerment.controller.rest;


import com.codegym.blog_managerment.model.Blog;
import com.codegym.blog_managerment.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable Integer id) {
        Blog blog = iBlogService.getById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


//    @PostMapping("/create")
//    public ResponseEntity<?> add(@RequestBody Blog newBlog){
//        iBlogService.c(newBlog);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
