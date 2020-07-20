package com.example.smartmart.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/stores/{storeId}/items")
    public List<Item> getAllItems(@PathVariable int storeId){
        return itemService.getAllItem(storeId);
    }

    @GetMapping("/stores/{storeId}/items/{itemId}")
    public Item getItem(@PathVariable int itemId, @PathVariable int storeId){
        return itemService.getItem(itemId);
    }

    @PutMapping("/stores/{storeId}/items")
    public void updateItem(@PathVariable int storeId, @RequestBody Item item){
        itemService.updateItem(item);
        return;
    }

    @PostMapping("/stores/{storeId}/items")
    public void saveItem(@PathVariable int storeId, @RequestBody Item item){
        itemService.saveItem(item);
        return;
    }

    @DeleteMapping("/stores/{storeId}/items/{itemId}")
    public void deleteItem(@PathVariable int storeId, @PathVariable int itemId){
        itemService.deleteItem(itemId);
        return;
    }

}