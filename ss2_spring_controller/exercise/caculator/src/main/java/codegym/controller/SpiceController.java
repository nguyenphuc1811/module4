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
        return "/calculator";
    }

    @PostMapping("/cv")
    public String getSpice(String operator, double number1, double number2, Model model) {
        double result = 0;
        String chat = "";
        switch (operator) {
            case "+":
                result = number1 + number2;
                chat = number1 + operator + number2 + " = " + result;
                break;
            case "-":
                result = number1 - number2;
                chat = number1 + operator + number2 + " = " + result;
                break;
            case "*":
                result = number1 * number2;
                chat = number1 + operator + number2 + " = " + result;
                break;
            default:
                if (number2 != 0) {
                    result = number1 / number2;
                    chat = number1 + operator + number2 + " = " + result;
                } else {
                    chat = "Không chia cho 0";
                }
                break;
        }
        model.addAttribute("result",chat);
        return "/calculator";
    }
}

