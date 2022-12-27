package com.example.app_borrow_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {
    @Pointcut("execution(* com.example.app_borrow_book.controller.BookController.*Book(..))")
    public void borrowOrPayBookMethod() {
    }

    @Before("borrowOrPayBookMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Phương thức đang sử dụng: " + joinPoint.getSignature().getName());
    }
}
