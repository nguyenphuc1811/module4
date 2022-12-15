package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping
public class SpiceController {
    @GetMapping("")
    public String displayC() {
        return "/spiceSandwich";
    }

    @PostMapping("/cv")
    public String getSpice(@RequestParam("condiment") String[] condiment, Model model) {
        if (condiment.length == 0) {
            model.addAttribute("condiment", "No spice");
        } else {
            model.addAttribute("condiment", Arrays.toString(condiment));
        }
        return "/spiceSandwich";
    }
}

