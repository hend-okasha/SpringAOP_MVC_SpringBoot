package com.example.orders.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;
import java.util.Map;

public class OrderView implements View {
    @Override
    public String getContentType() {
        return "text/plain;charset=UTF-8";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType(getContentType());
        response.getWriter().println(
                model.get("result")
        );
    }
}
