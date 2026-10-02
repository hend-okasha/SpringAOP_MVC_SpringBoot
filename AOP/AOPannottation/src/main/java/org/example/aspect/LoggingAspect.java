package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Pointcut("execution(* org.example.service.AccountService.*(..))")
    public void accountMethods() {
    }

    @Before("accountMethods()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(" Before Calling : " + joinPoint.getSignature().getName());
        System.out.println(" Before Args : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("accountMethods()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("after always run" );
    }

    @AfterReturning(pointcut = "accountMethods()",
                    returning = "result")
    public void logSuccess(JoinPoint joinPoint , Object result){
        System.out.println("success : " + joinPoint.getSignature()
                + "returned " + result);
    }

    @AfterThrowing(
            pointcut = "accountMethods()",
            throwing = "ex"
    )
    public void logFailure(JoinPoint joinPoint, Exception ex) {
        System.out.println("ERROR in " + joinPoint.getSignature() + ": " +
                ex.getMessage());
    }

    @Around("accountMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();

        System.out.println(" Around Start: " + proceedingJoinPoint.getSignature().getName());
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            System.out.println("Around End: " + proceedingJoinPoint.getSignature().getName() +
                    " took " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
