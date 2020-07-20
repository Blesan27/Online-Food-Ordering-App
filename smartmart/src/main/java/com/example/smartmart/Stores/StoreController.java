package com.example.smartmart.Stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class  StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/stores")
    public ArrayList<Store> getAllStores(){
        return  storeService.getAllStores();

    }

    @GetMapping("/stores/{id}")
    public Store getStore(@PathVariable int id){
        return storeService.getStore(id);
    }

    @PutMapping("/stores")
    public void updateStore(@RequestBody Store store){
        storeService.updateStore(store);
        return;
    }

    @PostMapping("/stores")
    public void saveStore(@RequestBody Store store){
        storeService.saveStore(store);
        return;
    }

    @DeleteMapping("stores/{id}")
    public void deleteStore(@PathVariable int id){
        storeService.deleteStore(id);
        return;
    }

}
