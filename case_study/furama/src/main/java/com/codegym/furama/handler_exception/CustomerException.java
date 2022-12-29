package com.codegym.furama.handler_exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerException extends Exception{
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
