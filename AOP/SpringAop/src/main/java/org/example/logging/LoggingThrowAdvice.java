package org.example.logging;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LoggingThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("logging throw advice");
        System.out.println("ERROR in " + method.getName() + ": " +
                ex.getMessage());
    }
}
