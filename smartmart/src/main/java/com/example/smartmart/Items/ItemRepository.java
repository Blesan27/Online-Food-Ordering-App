package com.example.smartmart.Items;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemRepository extends CrudRepository<Item, Integer> {

    public List<Item> findByStoreId(Integer storeId);
}
