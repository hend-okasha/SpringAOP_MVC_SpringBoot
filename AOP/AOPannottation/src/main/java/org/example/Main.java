package org.example;

import org.example.configuration.AppConfig;
import org.example.service.AccountService;
import org.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService = context.getBean(AccountService.class);
        OrderService orderService = context.getBean(OrderService.class);

        orderService.getOrder(10 ,"order");
        orderService.getOrder(10 ,"order");


        accountService.withdraw("Hind acc ", 50);
        accountService.getBalance(500);

    }
}