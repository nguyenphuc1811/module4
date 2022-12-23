package com.codegym.form_validate.controller;

import com.codegym.form_validate.model.User;
import com.codegym.form_validate.model.dto.UserDto;
import com.codegym.form_validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("")
    public String display(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/home";
    }

    @PostMapping("add")
    public String add(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/home";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
//        user.setSalary(0);
        iUserService.save(user);
        model.addAttribute("mess", "ADD thành công");
        return "user/result";
    }
}
