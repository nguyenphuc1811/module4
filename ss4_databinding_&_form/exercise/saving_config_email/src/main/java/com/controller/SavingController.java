package com.controller;

import com.model.Config;
import com.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SavingController {

    @Autowired
    private IConfigService configService;

    @RequestMapping("")
    public String displayList(Model model) {
        model.addAttribute("configList", configService.selectAll());
        return "/home";
    }

    @GetMapping("/edit/{name}")
    public String editForm( Model model, @PathVariable String name) {
        model.addAttribute("listLanguages", configService.selectLanguages());
        model.addAttribute("config", configService.selectConfig(name));
        model.addAttribute("listSize", configService.selectSize());
        return "/editForm";
    }
    @PostMapping("/edit/save")
    public String submit(@ModelAttribute Config config,Model model){
        model.addAttribute("mess",configService.confirm(config));
        model.addAttribute("configList",configService.selectAll());
        return "/home";
    }
}
