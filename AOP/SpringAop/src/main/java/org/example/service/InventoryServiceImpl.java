package org.example.service;

public class InventoryServiceImpl implements InventoryService {
    @Override
    public int checkStock(String sku) {
        return 5;
    }

    @Override
    public void reserveStock(String sku, int qty) {
        if (qty > 100) throw new IllegalStateException("qty should be less than 100");

    }
}
