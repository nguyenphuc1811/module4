package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/")
    public String display() {
        return "views/home";
    }


    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "views/security/myLogin";
    }

    @GetMapping("/error403")
    public String showError403() {
        return "views/security/error403";
    }

    @GetMapping("/login")
    public String showLoginHome() {
        return "views/home";
    }
}
