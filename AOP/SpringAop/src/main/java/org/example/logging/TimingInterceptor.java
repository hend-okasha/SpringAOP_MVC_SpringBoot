package org.example.logging;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Long start = System.currentTimeMillis();

        try{
            System.out.println("timing interceptor");
            System.out.println("Start :" + invocation.getMethod().getName());
            return invocation.proceed();
        }
        finally {
            Long end = System.currentTimeMillis();
            System.out.println("finally block");
            System.out.println("End :" + invocation.getMethod().getName());
            System.out.println("Execution time: " + (end - start) + " ms");

        }

    }
}
