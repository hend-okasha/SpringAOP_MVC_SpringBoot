package org.example.logging;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("logs AFTER : " + method.getName());
        System.out.println("Args : " + Arrays.toString(args));
        System.out.println("Return value : " + returnValue);
    }
}
