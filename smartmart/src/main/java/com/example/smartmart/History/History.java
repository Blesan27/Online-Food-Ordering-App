package com.example.smartmart.History;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class History {

    @Id
    @GeneratedValue
    private int id;
    private int customerId;
    private int itemId;
    private int storeId;
    private Date date;
    private String storeName;
    private String itemName;

    public History() {
    }
    public History(int id, int customerId, int itemId, Date date){
        this.id = id;
        this.itemId = itemId;
        this.customerId = customerId;
        this.date = date;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "history{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", itemId=" + itemId +
                '}';
    }
}
