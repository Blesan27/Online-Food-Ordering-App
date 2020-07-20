package com.example.smartmart.Stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repo;

    public ArrayList<Store> getAllStores(){
        return (ArrayList<Store>) repo.findAll();
    }

    public Store getStore(int storeId){
        return repo.findById(storeId).orElse(new Store());
    }

    public void saveStore(Store store){
        repo.save(store);
    }

    public void updateStore(Store store){
        repo.save(store);
    }

    public void deleteStore(int storeId){
        repo.deleteById(storeId);
    }
}
