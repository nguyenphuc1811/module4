package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ConvertController {

    @RequestMapping
    public String displayC() {
        return "/dictionary";
    }

    @RequestMapping("/diction")
    public String convert(Model model, String eng) {
        String[] arr1 = {"fly", "jump", "run", "punch", "walk", "eat"};
        String[] arr2 = {"Bay", "Nhảy", "Chạy", "Đấm", "Đi bộ", "Ăn"};
        String result = "Không tìm thấy " + eng;
        for (int i = 0; i < arr1.length; i++) {
            if (eng.toLowerCase().equals(arr1[i])) {
                result = eng + " = " + arr2[i];
                break;
            }
        }
        model.addAttribute("result", result);
        return "/dictionary";
    }
}

