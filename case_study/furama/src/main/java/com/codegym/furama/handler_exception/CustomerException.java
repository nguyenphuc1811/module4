package com.codegym.furama.handler_exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerException extends Exception{

//    @ExceptionHandler
//    public String errorCustomer(){
//        return "errorPage";
//    }
}
