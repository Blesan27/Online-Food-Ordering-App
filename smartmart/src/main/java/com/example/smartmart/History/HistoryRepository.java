package com.example.smartmart.History;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistoryRepository extends CrudRepository<History, Integer> {

    public List<History> getByCustomerId(int customerId);

}
