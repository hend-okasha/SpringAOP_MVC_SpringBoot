package com.example.orders.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LegacyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");

        ModelAndView mav = new ModelAndView("legacy");
        mav.addObject("orderId", id);

        return mav;
    }
}
