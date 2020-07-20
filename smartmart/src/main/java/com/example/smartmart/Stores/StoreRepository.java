package com.example.smartmart.Stores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface StoreRepository extends CrudRepository<Store, Integer> {
}
