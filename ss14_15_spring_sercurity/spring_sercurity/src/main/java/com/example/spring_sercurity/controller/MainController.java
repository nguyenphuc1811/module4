package com.example.spring_sercurity.controller;

import com.example.spring_sercurity.model.AppUser;
import com.example.spring_sercurity.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    public AppUserService appUserService;


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String goHome() {
        return "view/home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String goLogin() {
        return "view/login";
    }


    @RequestMapping(value = {"/sign-up"}, method = RequestMethod.GET)
    public String goSignUp(Model model) {
        model.addAttribute("user", new AppUser());
        return "view/signUp";
    }

    @RequestMapping(value = {"/sign-up"}, method = RequestMethod.POST)
    public String signUp(@ModelAttribute AppUser user) {
        appUserService.save(user);
        return "view/home";
    }
}
