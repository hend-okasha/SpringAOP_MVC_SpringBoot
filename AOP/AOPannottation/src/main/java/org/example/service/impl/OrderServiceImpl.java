package org.example.service.impl;

import org.example.Cacheable;
import org.example.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    @Cacheable
    public String getOrder(int id, String order) {
        return order;
    }
}
