package com.example.orders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailsController {

    @GetMapping("/orders/details")
    public String details(
            @RequestParam(defaultValue = "100") int id,
            Model model) {

        model.addAttribute("orderId", id);
        model.addAttribute("status", "PAID");

        return "details";
    }
}
