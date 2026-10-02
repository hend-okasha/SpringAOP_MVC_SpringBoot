package org.example;

import org.example.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryRunner {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryRunner(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void run() {
        inventoryService.checkStock("3");
        inventoryService.reserveStock("sku", 10);
    }
}
