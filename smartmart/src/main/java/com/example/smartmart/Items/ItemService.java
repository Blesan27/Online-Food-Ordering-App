package com.example.smartmart.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repo;


    public List<Item> getAllItem(Integer id){
        return repo.findByStoreId(id);
    }

    public Item getItem(int itemId){
        return repo.findById(itemId).orElse(new Item());
    }

    public void saveItem(Item item){
        repo.save(item);
    }

    public void updateItem(Item item){
        repo.save(item);
    }

    public void deleteItem(int itemId){
        repo.deleteById(itemId);
    }

}
