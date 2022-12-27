package com.example.app_borrow_book.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionBook {
    @ExceptionHandler(NullPointerException.class)
    public String errorNull(){
        return "error1";
    }
    @ExceptionHandler(Exception.class)
    public String errorAll(){
        return "error2";
    }
}
