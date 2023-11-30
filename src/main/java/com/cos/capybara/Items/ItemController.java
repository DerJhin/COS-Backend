package com.cos.capybara.Items;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/item")
public class ItemController {

    public final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id){
        return itemService.getItem(id);
    }
}
