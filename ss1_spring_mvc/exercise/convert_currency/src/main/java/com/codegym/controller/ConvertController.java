package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    @RequestMapping("")
    public String displayC() {
        return "/covertCurrency";
    }

    @RequestMapping("/cv")
    public String covertCurrency(Model model, double ip, String cv) {
        double result = 0;
        String chat = "";
        if (cv.equals("USD")) {
            result = ip * 23000;
            chat = ip + " USD = " + result + " VND";
        } else {
            result = ip / 23000;
            chat = ip + " VND = " + result + " USD";
        }
        model.addAttribute("chat", chat);
        return "/covertCurrency";
    }
}

