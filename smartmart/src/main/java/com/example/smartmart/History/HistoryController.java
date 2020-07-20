package com.example.smartmart.History;

import com.example.smartmart.Items.Item;
import com.example.smartmart.Items.ItemRepository;
import com.example.smartmart.Stores.Store;
import com.example.smartmart.Stores.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private StoreRepository Store_repo;

    @Autowired
    private ItemRepository Item_repo;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public List<History> getAllHistory(){
        return historyService.getAllHistory();
    }

    @GetMapping("/customers/{cId}/history")
    public List<History> getHistoryByCustomerId(@PathVariable int cId){
        return historyService.getHistoryByCustomerId(cId);
    }

    @PostMapping("/customers/{cId}/history")
    public void saveHistory(@PathVariable int cId, @RequestBody History history){
        history.setCustomerId(cId);

        Store s =Store_repo.findById(history.getStoreId()).orElse(new Store());

        Item i = Item_repo.findById(history.getItemId()).orElse(new Item());

        history.setStoreName(s.getStoreName());
        history.setItemName(i.getItemName());

        Calendar cal = Calendar.getInstance();

        history.setDate(cal.getTime());

        historyService.saveHistory(history);
    }

    @DeleteMapping("/customers/{cid}/history")
    public void deleteHistory(@PathVariable int cid){
        historyService.deleteHistory(cid);
    }

}
