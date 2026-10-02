package org.example.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.example.logging.LoggingAfterAdvice;
import org.example.logging.LoggingBeforeAdvice;
import org.example.logging.LoggingThrowAdvice;
import org.example.logging.TimingInterceptor;
import org.example.service.InventoryServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public InventoryServiceImpl inventoryServiceImpl(){
        return new InventoryServiceImpl();
    }

    @Bean
    public MethodBeforeAdvice loggingBeforeAdvice() {
        return new LoggingBeforeAdvice();
    }

    @Bean
    public AfterReturningAdvice loggingAfterAdvice() {
        return new LoggingAfterAdvice();
    }

    @Bean
    public ThrowsAdvice loggingThrowAdvice() {
        return new LoggingThrowAdvice();
    }

    @Bean
    public MethodInterceptor timingInterceptor() {
        return new TimingInterceptor();
    }

    @Bean
    public Advisor loggingBeforeAdvisor(MethodBeforeAdvice loggingBeforeAdvice) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("reserveStock");
        return new DefaultPointcutAdvisor(pointcut, loggingBeforeAdvice);
    }

    @Bean
    @Primary
    public ProxyFactoryBean inventoryService() {
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setTarget(inventoryServiceImpl());
        factory.setInterceptorNames( "loggingBeforeAdvisor",
                                     "loggingAfterAdvice",
                                     "loggingThrowAdvice",
                                     "timingInterceptor");

        return factory;
    }

}
