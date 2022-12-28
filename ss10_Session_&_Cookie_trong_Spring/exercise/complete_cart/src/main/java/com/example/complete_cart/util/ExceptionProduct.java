package com.example.complete_cart.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionProduct extends Exception {

    @ExceptionHandler(Exception.class)
    public String errorPage(){
        return "errorPage";
    }
}
