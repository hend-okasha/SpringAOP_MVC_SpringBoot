package com.example.orders.adapter;

import com.example.orders.handler.OrderHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class OrderHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof OrderHandler;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String orderId = request.getParameter("id");

        if (orderId == null) {
            orderId = "100";
        }

        OrderHandler orderHandler = (OrderHandler) handler;
        String result = orderHandler.processOrder(orderId);
        ModelAndView mav = new ModelAndView("orderSummary");

        mav.addObject("result", result);

        return mav;
    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return 0;
    }
}
