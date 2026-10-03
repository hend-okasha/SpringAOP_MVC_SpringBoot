package com.example.orders.handler;

public class SimpleOrderHandler implements OrderHandler{
    @Override
    public String processOrder(String orderId) {

            return "Order " + orderId + " confirmed successfully";
    }
}
