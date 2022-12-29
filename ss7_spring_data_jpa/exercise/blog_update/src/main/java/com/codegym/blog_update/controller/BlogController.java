//package com.codegym.blog_update.controller;
//
//import com.codegym.blog_update.model.Blog;
//import com.codegym.blog_update.repository.IPostRepository;
//import com.codegym.blog_update.service.IBlogService;
//import com.codegym.blog_update.service.IPostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//
//@Controller
//public class BlogController {
//    @Autowired
//    private IBlogService iBlogService;
//
//    @Autowired
//    private IPostService iPostService;
//
//    @GetMapping("")
//    public String display(@PageableDefault(size = 3) Pageable pageable, Model model) {
//        model.addAttribute("blogList", iBlogService.findAll(pageable));
//        return "home";
//    }
//
//    @GetMapping("/add")
//    public String add(Model model) {
//        model.addAttribute("blog", new Blog());
//        model.addAttribute("postList", iPostService.findAll());
//        return "add";
//    }
//
//    @PostMapping("/addConfirm")
//    public String addBlog(Blog blog) {
//        iBlogService.add(blog);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", iBlogService.getById(id));
//        model.addAttribute("postList", iPostService.findAll());
//        return "edit";
//    }
//
//    @PostMapping("/saveConfirm")
//    public String editConfirm(Blog blog, RedirectAttributes attributes) {
//        try {
//            if (iBlogService.update(blog)) {
//                attributes.addFlashAttribute("mess", "Edit thanh cong");
//            } else {
//                attributes.addFlashAttribute("mess", "Edit khong thanh cong");
//            }
//        } finally {
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("blog", iBlogService.getById(id));
//        model.addAttribute("postList", iPostService.findAll());
//        return "delete";
//    }
//
//    @PostMapping("/deleteConfirm")
//    public String deleteConfirm(Blog blog) {
//        iBlogService.deleteById(blog.getId());
//        return "redirect:/";
//    }
//}
