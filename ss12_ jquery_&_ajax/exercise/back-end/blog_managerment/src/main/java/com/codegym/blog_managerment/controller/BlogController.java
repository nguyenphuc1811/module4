package com.codegym.blog_managerment.controller;

import com.codegym.blog_managerment.model.Blog;
import com.codegym.blog_managerment.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("blogList", iBlogService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @PostMapping("/addConfirm")
    public String addBlog(Blog blog, Model model) {
        if (iBlogService.update(blog)) {
            model.addAttribute("mess", "Edit thành công");
        } else {
            model.addAttribute("mess", "Edit không thành công");
        }
        return display(model);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.getById(id));
        return "edit";
    }

    @PostMapping("/saveConfirm")
    public String editConfirm(Blog blog, RedirectAttributes attributes) {
        if (iBlogService.update(blog)) {
            attributes.addFlashAttribute("mess", "Edit thành công");
        } else {
            attributes.addFlashAttribute("mess", "Edit không thành công");
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.getById(id));
        return "delete";
    }

    @PostMapping("/deleteConfirm")
    public String deleteConfirm(Blog blog, Model model) {
        iBlogService.deleteById(blog.getId());
        return display(model);
    }
}
