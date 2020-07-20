package com.example.smartmart.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository repo;

    public List<History> getAllHistory(){
        return (List<History>) repo.findAll();
    }

    public List<History> getHistoryByCustomerId(int customerId){
        return repo.getByCustomerId(customerId);
    }

    public void deleteHistory(int cid){
        repo.deleteById(cid);
    }

    public void saveHistory(History history){
        repo.save(history);
    }
}
