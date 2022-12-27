package com.example.app_borrow_book.controller;

import com.example.app_borrow_book.service.IBookService;
import com.example.app_borrow_book.service.ICodeBookService;
import org.hibernate.criterion.NotNullExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    IBookService iBookService;

    @Autowired
    ICodeBookService iCodeBookService;

    @RequestMapping
    public String showList(Model model) {
        model.addAttribute("listBook", iBookService.findAll());
        return "list_book";
    }

    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "view_book";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id, Model model) {
        if (iBookService.findById(id).getQuantity() == 0) {
            model.addAttribute("mess", "Đã hết sách");
        } else {
            model.addAttribute("codeBook", iBookService.borrowBook(id));
        }
        return viewBook(id, model);
    }

    @GetMapping("/pay")
    public String showPayBook(int codeBook, Model model) throws NullPointerException {
        if (iCodeBookService.findByCodeBook(codeBook) == null) {
            model.addAttribute("mess", "Không tìm thấy sách");
            return "list_book";
        }
        model.addAttribute("codeBook", codeBook);
        model.addAttribute("book", iBookService.payBook(codeBook));
        return "pay_book";
    }

    @GetMapping("/payBook/{id}/{codeBook}")
    public String payBook(@PathVariable int id, @PathVariable int codeBook, RedirectAttributes attributes) {
        iBookService.payBookConfirm(id);
        iCodeBookService.removeCodeBook(codeBook);
        attributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/";
    }
}
