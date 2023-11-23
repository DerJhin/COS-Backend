package com.cos.capybara.Inventory;

import org.springframework.stereotype.Service;

@Service
public class InventoryService implements DefaultInventoryService{

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventory(Long id){
        return inventoryRepository.getReferenceById(id);
    }
}
