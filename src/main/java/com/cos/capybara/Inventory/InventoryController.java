package com.cos.capybara.Inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Inventory")
public class InventoryController {

    public final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public Inventory getInventory(@PathVariable Long id){
        return inventoryService.getInventory(id);
    }
}
