package com.codegym.furama.controller;

import com.codegym.furama.handler_exception.CustomerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(CustomerException.class)
    public String errorPage() {
        return "views/errorPage";
    }
}
