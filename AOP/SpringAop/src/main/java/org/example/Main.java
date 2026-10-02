package org.example;

import org.example.config.AppConfig;
import org.example.logging.LoggingAfterAdvice;
import org.example.logging.LoggingBeforeAdvice;
import org.example.logging.LoggingThrowAdvice;
import org.example.logging.TimingInterceptor;
import org.example.service.InventoryService;
import org.example.service.InventoryServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        InventoryService target = new InventoryServiceImpl();
//        ProxyFactory factory = new ProxyFactory(target);
//        factory.addAdvice(new LoggingAfterAdvice());
//        factory.addAdvice(new LoggingThrowAdvice());
//        factory.addAdvice(new TimingInterceptor());
//
//
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedName("reserveStock");
//        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new LoggingBeforeAdvice());
//        factory.addAdvisor(advisor);
//
//        InventoryService proxy = (InventoryService) factory.getProxy();
//        proxy.checkStock("3");
//        proxy.reserveStock("sku",10);
//


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        InventoryRunner runner =
                context.getBean(InventoryRunner.class);

        runner.run();

        context.close();

    }
}